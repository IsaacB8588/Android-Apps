package com.example.isaacblandin.scoringapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int blueScore = 0;
    int redScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void blueOneScore(View view){
        blueScore ++;
        displayBlueScore(blueScore);
    }

    public void setRedScore(View view){
        redScore ++;
        displayRedScore(redScore);
    }

    public void displayBlueScore(int score){
        TextView scoreView = (TextView) findViewById(R.id.blueScore);
        scoreView.setText("" + score);
    }

    public void displayRedScore(int score){
        TextView scoreView = (TextView) findViewById(R.id.redScore);
        scoreView.setText("" + score);
    }
}
