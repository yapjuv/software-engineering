package com.example.viceseethee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    Button mbutton_track_vices;
    Button mbutton_stat;
    Button mbutton_get_help;
    ImageButton mimagebutton_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mbutton_track_vices = (Button)findViewById(R.id.button_track);
        mbutton_stat = (Button)findViewById(R.id.button_stat);
        mbutton_get_help = (Button)findViewById(R.id.button_get_help);
        mimagebutton_logout = (ImageButton)findViewById(R.id.imageButton_logout);

        mbutton_track_vices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent trackintent = new Intent (HomeActivity.this,TrackActivity.class);
                startActivity(trackintent);
            }
        });

        mbutton_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statintent = new Intent (HomeActivity.this,StatActivity.class);
                startActivity(statintent);
            }
        });

        mbutton_get_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gethelpintent = new Intent (HomeActivity.this,HelpActivity.class);
                startActivity(gethelpintent);
            }
        });

        mimagebutton_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outintent = new Intent (HomeActivity.this,MainActivity.class);
                startActivity(outintent);
                finish();
            }
        });
    }
}
