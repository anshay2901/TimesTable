package com.anshaysingh.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView myListView;

    public void createTimesTable(int number1) {
        ArrayList <String>number = new ArrayList<String>();

        for(int i = 1; i <= 20; i++) {
            number.add(Integer.toString(i*number1));

        }
        ArrayAdapter <String>arrayAdapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, number);
        myListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.myListView);
        final SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int changed_value;
                if(progress < min) {
                    changed_value = min;
                    seekBar.setProgress(min);
                }
                else {
                    changed_value = progress;
                }

                createTimesTable(changed_value);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        createTimesTable(10);

    }
}
