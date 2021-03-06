
package com.phoenices.chapters;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {

    private Button bNewGame;
    private Button bResume;
    private Button bSettings;

    private View.OnClickListener listenerNewGame = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentSelect = new Intent(WelcomeActivity.this,
                    SelectActivity.class);

            startActivity(intentSelect);
            return;
        }
    };

    private View.OnClickListener listenerResume = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentResume= new Intent(WelcomeActivity.this,
                    ResumeActivity.class);

            startActivity(intentResume);
            return;
        }
    };

    private View.OnClickListener listenerSettings = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentSettings = new Intent(WelcomeActivity.this,
                    SettingsActivity.class);

            startActivity(intentSettings);
            return;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        bNewGame = (Button) findViewById(R.id.btn_newgame);
        bResume = (Button) findViewById(R.id.btn_resume);
        bSettings = (Button) findViewById(R.id.btn_settings);

        bNewGame.setOnClickListener(listenerNewGame);
        bResume.setOnClickListener(listenerResume);
        bSettings.setOnClickListener(listenerSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
