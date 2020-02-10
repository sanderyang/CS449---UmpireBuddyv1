package com.example.umpirebuddy_yang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AppVariables counters = new AppVariables();
    private Button CountBtn, StrikesBtn, ResetBtn, ExitBtn, AboutBtn;
    private TextView CountOfBalls, CountOfStrikes;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;


    private void statusButton(boolean b){
        StrikesBtn.setEnabled(b);
        CountBtn.setEnabled(b);
        AboutBtn.setEnabled(b);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountBtn = findViewById(R.id.CountBtn);
        StrikesBtn = findViewById(R.id.StrikesBtn);
        ResetBtn = findViewById(R.id.ResetBtn);
        ExitBtn = findViewById(R.id.ExitBtn);
        AboutBtn = findViewById(R.id.AboutBtn);
        CountOfBalls = findViewById(R.id.CountOfBalls);
        CountOfStrikes = findViewById(R.id.CountOfStrikes);
        relativeLayout = findViewById(R.id.relative);
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        CountOfBalls.setText("0");
        CountOfStrikes.setText("0");

        CountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counters.getCount() == 3) {
                    counters.addToCount();
                    CountOfBalls.setText(String.valueOf(counters.getCount()));
                    statusButton(false);
                    layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.ball_pop_up, null, false);
                    final PopupWindow pw = new PopupWindow(popupView,1050,400, true);
                    pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 19, 500);
                    Button BallPopBtn =  popupView.findViewById(R.id.ballClose);
                    BallPopBtn.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View popupView) {
                            pw.dismiss();
                        }
                    });
                }
                else{
                    counters.addToCount();
                    CountOfBalls.setText(String.valueOf(counters.getCount()));
                }
            }
        });

        StrikesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counters.getCount2() == 2){
                    counters.addToCount2();
                    CountOfStrikes.setText(String.valueOf(counters.getCount2()));
                    statusButton(false);
                    layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    View popupView = layoutInflater.inflate(R.layout.strike_pop_up, null, false);
                    final PopupWindow pw = new PopupWindow(popupView,1050,400, true);

                    pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 19, 500);
                    Button StrikesCloseBtn = popupView.findViewById(R.id.strikeCloseBtn);
                    StrikesCloseBtn.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View popupView) {
                            pw.dismiss();
                        }
                    });
                }
                else{
                    counters.addToCount2();
                    CountOfStrikes.setText(String.valueOf(counters.getCount2()));
                }
            }
        });

        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusButton(true);
                counters.setCount(0);
                counters.setCount2(0);
                CountOfStrikes.setText(String.valueOf(counters.getCount2()));
                CountOfBalls.setText(String.valueOf(counters.getCount()));
            }
        });

        AboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View popupView = layoutInflater.inflate(R.layout.about_pop_up, null, false);
                final PopupWindow pw = new PopupWindow(popupView,1050,400, true);

                pw.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 19, 500);
                Button AboutCloseBtn = popupView.findViewById(R.id.aboutCloseBtn);
                AboutCloseBtn.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View popupView) {
                        pw.dismiss();
                    }
                });
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