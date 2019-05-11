package com.example.viceseethee;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrackActivity extends AppCompatActivity {

    DatabaseHelper sqliteHelper;
    TextView mdatetime;
    TextView cigconsume;
    TextView cigmoney;
    TextView beerconsume;
    TextView beermoney;
    ImageButton cigplus;
    ImageButton beerplus;
    Button savebtn;
    Button resetbtn;
    int countercig;
    int counterbeer;
    int countercigcost;
    int counterbeercost;
    int cigprice = 7;
    int beerprice = 35;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String currentTime = mdformat.format(calendar.getTime());


        mdatetime = (TextView)findViewById(R.id.textView_date);
        mdatetime.setText(currentDate);
        cigconsume = (TextView)findViewById(R.id.textView_cigcount);
        cigmoney = (TextView)findViewById(R.id.textView_cigcost);
        beerconsume = (TextView)findViewById(R.id.textView_beercount);
        beermoney = (TextView)findViewById(R.id.textView_beercost);
        cigplus = (ImageButton)findViewById(R.id.imageButton_smoking);
        beerplus = (ImageButton)findViewById(R.id.imageButton_drinking);
        savebtn = (Button)findViewById(R.id.button_saveData);
        resetbtn = (Button)findViewById(R.id.button_reset);


        cigplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pluscig();
            }
        });
        beerplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusbeer();
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = mdatetime.getText().toString();
                String yosi = cigconsume.getText().toString();
                String yosimoney = cigmoney.getText().toString();
                String alak = beerconsume.getText().toString();
                String alakmoney = beermoney.getText().toString();


                sqliteHelper.insertData(new Data(date, yosi, yosimoney, alak, alakmoney, null));
                Toast.makeText(TrackActivity.this,"Data Inserted", Toast.LENGTH_SHORT).show();


            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countercig = 0;
                countercigcost = 0;
                counterbeer = 0;
                counterbeercost = 0;
                cigconsume.setText(Integer.toString(countercig));
                cigmoney.setText(Integer.toString(countercigcost));
                beerconsume.setText(Integer.toString(counterbeer));
                beermoney.setText(Integer.toString(counterbeercost));
            }
        });


    }

    private void pluscig() {
        countercig++;
        countercigcost = countercig * cigprice;
        cigconsume.setText(Integer.toString(countercig));
        cigmoney.setText(Integer.toString(countercigcost));
        if (countercig ==1) {
            AlertDialog.Builder builder4 = new AlertDialog.Builder(TrackActivity.this);
                    builder4.setCancelable(true);
                    builder4.setTitle("Did you know?");
                    builder4.setMessage("Research has shown that smoking reduces life expectancy by seven to eight years. On average, each cigarette shortens your life anywhere from seven to eleven minutes. In other words, the time it takes you to smoke a cigarette equals the time that cigarette takes off of your life.");
                    builder4.show();

        }

        else if (countercig == 20) {
            AlertDialog.Builder builder = new AlertDialog.Builder(TrackActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Too Much Alert");
                    builder.setMessage("You already finished a whole pack. I think its already enough for today.");
                    builder.show();
        }






    }

    private void plusbeer() {
        counterbeer++;
        counterbeercost = counterbeer * beerprice;
        beerconsume.setText(Integer.toString(counterbeer));
        beermoney.setText(Integer.toString(counterbeercost));
        if (counterbeer == 1) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(TrackActivity.this);
                    builder2.setCancelable(true);
                    builder2.setTitle("Drinking Alert!");
                    builder2.setMessage("Please drink responsibly!");
                    builder2.show();
        }
        else if (counterbeer == 6) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(TrackActivity.this);
                    builder3.setCancelable(true);
                    builder3.setTitle("Drinking Alert!");
                    builder3.setMessage("You already drank a case. Please don't drink and drive!");
                    builder3.show();
        }

    }

}
