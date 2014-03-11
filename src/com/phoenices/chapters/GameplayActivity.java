package com.phoenices.chapters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.ETRACKING_STATE;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.MetaioSDK;
import com.metaio.sdk.jni.TrackingValues;
import com.metaio.sdk.jni.Vector3d;
import com.metaio.tools.io.AssetsManager;

public class GameplayActivity extends ARViewActivity {

	private IGeometry mcampus;
	private IGeometry mefforts;
	//private IGeometry mfirealarm;
	//private IGeometry mfoosball;
	private IGeometry mfundamentals;
	private IGeometry mguy;
	//private IGeometry mhinkley;
	private IGeometry mobservatory;
	private IGeometry mModel;
	private TextView storytext;	
	
	
	
	
	@Override
    protected int getGUILayout() {
		return R.layout.activity_gameplay;

	}

	public void onButtonClick(View v)
	{
		finish();
	}

	
	   @Override
	    protected void loadContents() 
	    {  
		   try {  
	       		//Load asset folder	            
	            AssetsManager.extractAllAssets(this, true);
	          
	            // Getting a file path for tracking configuration XML file
	            String trackingConfigFile = AssetsManager.getAssetPath(getApplicationContext(), "TrackingData_MarkerlessFast.xml");
	            
	            // Assigning tracking configuration
	            boolean result = metaioSDK.setTrackingConfiguration(trackingConfigFile); 
	            MetaioDebug.log("Tracking data loaded: " + result); 
	            
	            // Getting a file path for all geometries
	            //Basically, the last argument is the file that we want to show when the object is tracked
	            String metaioManModel = AssetsManager.getAssetPath(getApplicationContext(), "metaioman.md2");   
	            String campusmovie = AssetsManager.getAssetPath(getApplicationContext(), "campus.3g2");
	            String guy = AssetsManager.getAssetPath(getApplicationContext(), "speechbubble.png");
	            //String firealarm = AssetsManager.getAssetPath(getApplicationContext(), "firealarm.mp3");
	            String observatory = AssetsManager.getAssetPath(getApplicationContext(), "thing.gif");
	            String efforts = AssetsManager.getAssetPath(getApplicationContext(), "discouragement.jpg");
	            String fundamentals = AssetsManager.getAssetPath(getApplicationContext(), "img.png");
	            //load all geometries 
	            //actually loading the geometry from above
	            //these constructors are different depending on the asset type. you'll only need these three
	            mcampus = metaioSDK.createGeometryFromMovie(campusmovie, true);
	            mModel = metaioSDK.createGeometry(metaioManModel);
	            mguy = metaioSDK.createGeometryFromImage(guy);
	            //mfirealarm = metaioSDK.createGeometryFromImage(guy);
	            mobservatory = metaioSDK.createGeometryFromImage(efforts);
	            mefforts = metaioSDK.createGeometryFromImage(efforts);
	            mfundamentals = metaioSDK.createGeometryFromImage(fundamentals);
	            //ignore
	            //TrackingValues falarm = metaioSDK.getTrackingValues(6);
	            
	            //set coordinate ids
	            //This corresponds to the number in the tracking data xml 
	            //1 = the first item, which is campus
	            //Just set the models with the trackers. 
	            mModel.setCoordinateSystemID(1);
	            mcampus.setCoordinateSystemID(2);
	            mfundamentals.setCoordinateSystemID(3);
	            mguy.setCoordinateSystemID(4);
	            mefforts.setCoordinateSystemID(5);
	            mobservatory.setCoordinateSystemID(6);
	                if (mModel != null) {
	                    // Set geometry properties
	                    mModel.setScale(new Vector3d(4.0f, 4.0f, 4.0f));
	                   
	                    }
	                 else {
	                      MetaioDebug.log(Log.ERROR, "Error loading geometry: "+metaioManModel);   
	                }
	               
	           // Ignore this. I'm trying to figure out how to check when we're tracking.
	           // if(falarm.isTrackingState()) {
	            	//playSound();
	        //    }
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }
                   
	    
	            
	         // Getting a file path for a movie
	         /*   final String pcampus = AssetsManager.getAssetPath(getApplicationContext(), "Chapters/assets/campus.3g2");       
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
	            */
	        } 
	    
	
	   //beginning to tie instant tracking to a new object instead of all objects every time.
		public void onInstantObjectDetected(View v)
		{
			//mTiger.setVisible(false);
			metaioSDK.startInstantTracking("INSTANT_3D");
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





