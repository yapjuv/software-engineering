package com.example.viceseethee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    ImageButton mbutton_back;
    ImageButton mbuttong_nica;
    ImageButton mbutton_aap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mbutton_back = (ImageButton)findViewById(R.id.imageButton_back);
        mbuttong_nica = (ImageButton)findViewById(R.id.imageButton_nanonymous);
        mbutton_aap = (ImageButton)findViewById(R.id.imageButton_aap);

        mbutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent = new Intent (HelpActivity.this,HomeActivity.class);
                startActivity(backintent);
                finish();
            }
        });

        mbuttong_nica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nicaintent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://nicotine-anonymous.org/"));
                startActivity(nicaintent);
            }
        });

        mbutton_aap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aapintent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.aaphilippines.com/"));
                startActivity(aapintent);
            }
        });
    }
}
