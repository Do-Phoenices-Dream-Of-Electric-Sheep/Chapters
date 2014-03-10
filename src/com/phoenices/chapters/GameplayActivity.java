package com.phoenices.chapters;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.Rotation;
import com.metaio.sdk.jni.TrackingValuesVector;
import com.metaio.sdk.jni.Vector3d;
import com.metaio.tools.io.AssetsManager;

public class GameplayActivity extends ARViewActivity {

	private IGeometry mcampus;
	private IGeometry mefforts;
	private IGeometry mfirealarm;
	private IGeometry mfoosball;
	private IGeometry mfundamentals;
	private IGeometry mguy;
	private IGeometry mhinkley;
	private IGeometry mobservatory;
	private TextView storytext;	
	protected int getGUILayout() {
		return R.layout.activity_gameplay;

	}

	public void onButtonClick(View v)
	{
		finish();
	}


	protected void loadContents() 
	{
		try
		{
			//getCoordinateSystemID
			//http://helpdesk.metaio.com/questions/15089/how-to-find-out-which-coordinate-system-is-currently-tracked
	
			// Getting a file path for tracking configuration XML file
			String trackingConfigFile = AssetsManager.getAssetPath(getApplicationContext(), "Chapters/assets/TrackingData_MarkerlessFast.xml");

			// Assigning tracking configuration
			boolean result = metaioSDK.setTrackingConfiguration(trackingConfigFile); 
			MetaioDebug.log("Tracking data loaded: " + result); 

			// Getting a file path for a movie
			final String pcampus = AssetsManager.getAssetPath(getApplicationContext(), "Chapters/assets/campus.3g2");		
			//storytext.setVisibility(TextView.GONE);
			if (pcampus != null) 
			{
				// Loading movie
				mcampus = metaioSDK.createGeometryFromMovie(pcampus, true);
				if (mcampus != null) 
				{
					// Set geometry properties
					mcampus.setScale(5.0f);
					//start movie
					mcampus.startMovieTexture(true);
					//storytext.setVisibility(TextView.VISIBILE);
					storytext = (TextView) this.findViewById(R.id.textView1);
					storytext.setText("testing testing");

				}
				else
					MetaioDebug.log(Log.ERROR, "Error loading geometry: "+mcampus);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void onGeometryTouched(IGeometry geometry)
	{
		// Not used in this tutorial
	}


	@Override
	protected IMetaioSDKCallback getMetaioSDKCallbackHandler()
	{
		// No callbacks needed in this tutorial
		return null;
	}	



}





