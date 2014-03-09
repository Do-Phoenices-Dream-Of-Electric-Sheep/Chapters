package com.phoenices.chapters;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
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
			// Getting a file path for tracking configuration XML file
			String trackingConfigFile = AssetsManager.getAssetPath(getApplicationContext(), "Chapters/Assets/TrackingData_MarkerlessFast.xml");
			
			// Assigning tracking configuration
			boolean result = metaioSDK.setTrackingConfiguration(trackingConfigFile); 
			MetaioDebug.log("Tracking data loaded: " + result); 
	        
			// Getting a file path for a 3D geometry
			String campus = AssetsManager.getAssetPath(getApplicationContext(), "Chapters/Assets/campus.3g2");			
			if (campus != null) 
			{
				// Loading 3D geometry
				mcampus = metaioSDK.createGeometry(campus);
				if (mcampus != null) 
				{
					// Set geometry properties
					mcampus.setScale(new Vector3d(4.0f, 4.0f, 4.0f));
					
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
	
	
	



