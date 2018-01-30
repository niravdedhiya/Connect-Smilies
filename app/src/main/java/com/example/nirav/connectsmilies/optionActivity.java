package com.example.nirav.connectsmilies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class optionActivity extends AppCompatActivity {

    public void three(View view) {

        Intent i = new Intent(getApplicationContext(), ultraActivity.class);
        startActivity(i);
    }

    public void four(View view) {

        Intent i = new Intent(getApplicationContext(), ultra2Activity.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }
}
