package com.example.isaacblandin.roverruckusscoring;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.app.Fragment;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    //storage variables for main scores
    public int autoScore = 0;
    public int teleOpScore = 0;
    public int endGameScore = 0;
    public int totalScore = 0;

    //storage variables for autonomous
    public boolean landed = false;
    public boolean sampled = false;
    public boolean marker = false;
    public boolean parked = false;

    //storage variables for TeleOp
    public int gold = 0;
    public int silver = 0;
    public int corner = 0;

    //storage variables for EndGame
    public boolean hang = false;
    public boolean partial = false;
    public boolean full = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new AutoFragment());

        toolbar = getSupportActionBar();
        toolbar.setTitle(R.string.title_Autonomous);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_autonomous:
                    fragment = new AutoFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_teleop:
                    fragment = new TeleOpFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_endgame:
                    fragment = new EndGameFragment();
                    loadFragment(fragment);
                    return true;

            }
            return false;
        }
    };

    public void updateTotal(){
        totalScore = autoScore + teleOpScore + endGameScore;
        toolbar.setTitle("Total: " + totalScore);
    }

    public void setTitleScore(){
        toolbar.setTitle("Score Summary");
    }
    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
