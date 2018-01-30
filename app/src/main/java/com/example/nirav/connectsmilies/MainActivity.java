package com.example.nirav.connectsmilies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

        public void easy(View view) {

            Intent i = new Intent(getApplicationContext(), simpleActivity.class);
            startActivity(i);
        }



        public void ultra(View view) {

            Intent i = new Intent(getApplicationContext(), optionActivity.class);
            startActivity(i);
        }

        public void about(View view) {

            Intent i = new Intent(getApplicationContext(), aboutActivity.class);
            startActivity(i);
        }
        public void exit(View view) {
            finish();
            moveTaskToBack(true);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
