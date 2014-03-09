package com.phoenices.chapters;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends Activity {

	private Button story;
	
	private View.OnClickListener listenerStory = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentStory = new Intent(SelectActivity.this,
                    GameplayActivity.class);

            startActivity(intentStory);
            return;
        }
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		
		story = (Button) findViewById(R.id.button1);
		
		story.setOnClickListener(listenerStory);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

}
