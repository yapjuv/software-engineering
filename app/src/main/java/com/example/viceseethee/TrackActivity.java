package com.example.viceseethee;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrackActivity extends AppCompatActivity {

    DatabaseHelper db;
    TextView mdatetime;
    TextView cigconsume;
    TextView cigmoney;
    TextView beerconsume;
    TextView beermoney;
    TextView previousDate = (TextView)findViewById(R.id.textView_previousdate);
    ImageButton cigplus;
    ImageButton beerplus;
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

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String prevDate = sharedPreferences.getString("date", null);
        if (prevDate == null) {

        }
        else {
            if (currentDate.equals(prevDate)) {
                //SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                int yosicounter = sharedPreferences.getInt("yosicounter", 0);
                int yosicost = sharedPreferences.getInt("yosicost", 0);
                int inomcounter = sharedPreferences.getInt("inomcounter", 0);
                int inomcost = sharedPreferences.getInt("inomcost", 0);

                if (yosicounter == 0 && yosicost == 0 && inomcost == 0 && inomcounter == 0) {
                    countercig = 0;
                    countercigcost = 0;
                    counterbeer = 0;
                    counterbeercost = 0;
                    cigconsume.setText(Integer.toString(0));
                    cigmoney.setText(Integer.toString(0));
                    beerconsume.setText(Integer.toString(0));
                    beermoney.setText(Integer.toString(0));
                } else {
                    countercig = sharedPreferences.getInt("yosicounter", yosicounter);
                    countercigcost = sharedPreferences.getInt("yosicost", yosicost);
                    counterbeer = sharedPreferences.getInt("inomcounter", inomcounter);
                    counterbeercost = sharedPreferences.getInt("inomcost", inomcost);
                    cigconsume.setText(Integer.toString(countercig));
                    cigmoney.setText(Integer.toString(countercigcost));
                    beerconsume.setText(Integer.toString(counterbeer));
                    beermoney.setText(Integer.toString(counterbeercost));
                }
                // String counteryosi = cigconsume.getText().toString().trim();
                // String counteryosicost = cigmoney.getText().toString().trim();
                // String counterinom = beerconsume.getText().toString().trim();
                // String counterinomcost = beermoney.getText().toString().trim();
                // final boolean b = db.insertData(previousDate, counteryosi, counteryosicost, counterinom, counterinomcost);

                // countercig=0;
                // countercigcost=0;
                // counterbeer=0;
                // counterbeercost=0;
                // cigconsume.setText(Integer.toString(0));
                // cigmoney.setText(Integer.toString(0));
                // beerconsume.setText(Integer.toString(0));
                // beermoney.setText(Integer.toString(0));





            } else {
                //SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                int yosicounter = sharedPreferences.getInt("yosicounter", 0);
                int yosicost = sharedPreferences.getInt("yosicost", 0);
                int inomcounter = sharedPreferences.getInt("inomcounter", 0);
                int inomcost = sharedPreferences.getInt("inomcost", 0);

                if (yosicounter == 0 && yosicost == 0 && inomcost == 0 && inomcounter == 0) {
                    countercig = 0;
                    countercigcost = 0;
                    counterbeer = 0;
                    counterbeercost = 0;
                    cigconsume.setText(Integer.toString(0));
                    cigmoney.setText(Integer.toString(0));
                    beerconsume.setText(Integer.toString(0));
                    beermoney.setText(Integer.toString(0));
                } else {
                    countercig = sharedPreferences.getInt("yosicounter", yosicounter);
                    countercigcost = sharedPreferences.getInt("yosicost", yosicost);
                    counterbeer = sharedPreferences.getInt("inomcounter", inomcounter);
                    counterbeercost = sharedPreferences.getInt("inomcost", inomcost);
                    cigconsume.setText(Integer.toString(countercig));
                    cigmoney.setText(Integer.toString(countercigcost));
                    beerconsume.setText(Integer.toString(counterbeer));
                    beermoney.setText(Integer.toString(counterbeercost));
                }

                //countercig=0;
                //countercigcost=0;
                //counterbeer=0;
                //counterbeercost=0;
                //cigconsume.setText(Integer.toString(0));
                //cigmoney.setText(Integer.toString(0));
                //beerconsume.setText(Integer.toString(0));
                //beermoney.setText(Integer.toString(0));


            }
        }

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

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("yosicounter", countercig);
        editor.putInt("yosicost", countercigcost);
        editor.putString("date", String.valueOf(mdatetime));
        editor.commit();


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

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("inomcounter", counterbeer);
        editor.putInt("inomcost", counterbeercost);
        editor.putString("date", String.valueOf(mdatetime));
        editor.commit();

    }

}
