package com.example.umpirebuddy_yang;

import androidx.appcompat.app.AppCompatActivity;
import com.example.umpirebuddy_yang.AppVariables;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppVariables counters = new AppVariables();
    private Button CountBtn, StrikesBtn, ResetBtn, ExitBtn;
    private TextView CountOfBalls, CountOfStrikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountBtn = findViewById(R.id.CountBtn);
        StrikesBtn = findViewById(R.id.StrikesBtn);
        ResetBtn = findViewById(R.id.ResetBtn);
        ExitBtn = findViewById(R.id.ExitBtn);
        CountOfBalls = findViewById(R.id.CountOfBalls);
        CountOfStrikes = findViewById(R.id.CountOfStrikes);
        CountOfBalls.setText("0");
        CountOfStrikes.setText("0");

        CountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counters.addToCount();
                CountOfBalls.setText(String.valueOf(counters.getCount()));
            }
        });

        StrikesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counters.addToCount2();
                CountOfStrikes.setText(String.valueOf(counters.getCount2()));
            }
        });

        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counters.setCount(0);
                counters.setCount2(0);
                CountOfStrikes.setText(String.valueOf(counters.getCount2()));
                CountOfBalls.setText(String.valueOf(counters.getCount()));
            }
        });

        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}