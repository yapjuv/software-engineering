package com.example.viceseethee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class StatActivity extends AppCompatActivity {


    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        barChart = (BarChart)findViewById(R.id.barchart_data);

        ArrayList vices =  new ArrayList();

        vices.add(new BarEntry(945f, 0));
        vices.add(new BarEntry(1040f, 1));
        vices.add(new BarEntry(1133f, 2));
        vices.add(new BarEntry(1240f, 3));
        vices.add(new BarEntry(1369f, 4));
        vices.add(new BarEntry(1487f, 5));
        vices.add(new BarEntry(1501f, 6));
        vices.add(new BarEntry(1645f, 7));
        vices.add(new BarEntry(1578f, 8));
        vices.add(new BarEntry(1695f, 9));

        ArrayList day = new ArrayList();

        day.add("May 9, 2019");
        day.add("May 10, 2019");
        day.add("May 11, 2019");
        day.add("May 12, 2019");
        day.add("May 13, 2019");
        day.add("May 14, 2019");
        day.add("May 15, 2019");

        BarDataSet bardataset = new BarDataSet(vices, "Cigarette and Beer consumption");
        barChart.animateY(5000);
        BarData data = new BarData((IBarDataSet) day, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);


    }
}
