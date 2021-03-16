package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void generate( int timeTable){
        ArrayList<String> timeTableArray = new ArrayList<String>();
        for (int j = 1;j<=10;j++){
            timeTableArray.add(Integer.toString(j*timeTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,timeTableArray);
        listView.setAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.list);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser ) {
                int min = 1;
                int timeTable;
                if(progress<min){
                    timeTable = min;
                    seekBar.setProgress(min);
                }else{
                    timeTable = progress;
                }
                Log.i("Time table value ",Integer.toString(timeTable));
                generate(timeTable);
            }

            @Override
            public void onStartTrackingTouch( SeekBar seekBar ) {

            }

            @Override
            public void onStopTrackingTouch( SeekBar seekBar ) {

            }
        });
    }
}