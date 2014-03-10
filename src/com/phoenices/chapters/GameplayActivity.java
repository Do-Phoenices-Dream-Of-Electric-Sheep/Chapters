package com.phoenices.chapters;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
//	          //getCoordinateSystemID
//	          //http://helpdesk.metaio.com/questions/15089/how-to-find-out-which-coordinate-system-is-currently-tracked
//	          TrackingValuesVector poses = metaioSDK.getTrackingValues();
//	          if (poses.size() != 0) {
//	              mcampus.setCoordinateSystemID(poses.get(1).getCoordinateSystemID());
	//
//	          }
//	          
//	          
//	          // Getting a file path for a movie
//	          final String pcampus = AssetsManager.getAssetPath(getApplicationContext(), "campus.3g2");       
//	          //storytext.setVisibility(TextView.GONE);
//	          if (pcampus != null) 
//	          {
//	              // Loading movie
//	              mcampus = metaioSDK.createGeometryFromMovie(pcampus, true);
//	              if (mcampus != null) 
//	              {
//	                  // Set geometry properties
//	                  mcampus.setScale(5.0f);
//	                  //start movie
//	                  mcampus.startMovieTexture(true);
//	                  //storytext.setVisibility(TextView.VISIBILE);
//	                  storytext = (TextView) this.findViewById(R.id.textView1);
//	                  storytext.setText("testing testing");
//	                  
//	              }
//	              else
//	                  MetaioDebug.log(Log.ERROR, "Error loading geometry: "+mcampus);
//	          }

	       
	        try {
	            
	            AssetsManager.extractAllAssets(this, true);
	            
	            // Getting a file path for tracking configuration XML file
	            String trackingConfigFile = AssetsManager.getAssetPath(getApplicationContext(), "TrackingData_MarkerlessFast.xml");
	            
	            // Assigning tracking configuration
	            boolean result = metaioSDK.setTrackingConfiguration(trackingConfigFile); 
	            MetaioDebug.log("Tracking data loaded: " + result); 
	            
	            // Getting a file path for a 3D geometry
	            String metaioManModel = AssetsManager.getAssetPath(getApplicationContext(), "metaioman.md2");         
	            if (metaioManModel != null) {
	                // Loading 3D geometry
	                mModel = metaioSDK.createGeometry(metaioManModel);
	                if (mModel != null) {
	                    // Set geometry properties
	                    mModel.setScale(new Vector3d(4.0f, 4.0f, 4.0f));
	                } else {
	                      MetaioDebug.log(Log.ERROR, "Error loading geometry: "+metaioManModel);   
	                }
	            }
	            
	            String campusModel = AssetsManager.getAssetPath(getApplicationContext(), "campus.3g2");
	            
	        } catch (Exception e) {
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
	
	
	



