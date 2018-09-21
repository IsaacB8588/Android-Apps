package com.example.isaacblandin.roverruckusscoring;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {


    public ScoreFragment() {
        // Required empty public constructor
    }

    TextView autoView;
    TextView teleOpView;
    TextView endGameView;

    TextView totalView;

    private int autoTotal;
    private int teleOpTotal;
    private int endGameTotal;

    private int totalVar;

    Button clearBtn;
    Button exitBtn;

    MainActivity mainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragment =inflater.inflate(R.layout.fragment_score, container, false);
        mainActivity = (MainActivity) getActivity();

        autoView = (TextView) myFragment.findViewById(R.id.autoTotal);
        teleOpView = (TextView) myFragment.findViewById(R.id.teleOpTotal);
        endGameView = (TextView) myFragment.findViewById(R.id.endGameTotal);

        totalView = (TextView) myFragment.findViewById(R.id.totalView);

        update();
        mainActivity.setTitleScore();

        clearBtn = (Button) myFragment.findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        exitBtn = (Button) myFragment.findViewById(R.id.exit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.loadFragment(new AutoFragment());
            }
        });

        // Inflate the layout for this fragment
        return myFragment;
    }

    public void update(){

        autoTotal = mainActivity.autoScore;
        teleOpTotal = mainActivity.teleOpScore;
        endGameTotal = mainActivity.endGameScore;
        totalVar = mainActivity.totalScore;

        autoView.setText("" + autoTotal);
        teleOpView.setText("" + teleOpTotal);
        endGameView.setText("" + endGameTotal);
        totalView.setText("" + totalVar);

    }

    public void clear(){

        //reset score totals
        mainActivity.autoScore = 0;
        mainActivity.teleOpScore = 0;
        mainActivity.endGameScore = 0;
        mainActivity.totalScore = 0;
        //reset auto storage
        mainActivity.landed = false;
        mainActivity.sampled = false;
        mainActivity.marker = false;
        mainActivity.parked = false;
        //reset teleop storage
        mainActivity.gold = 0;
        mainActivity.silver = 0;
        mainActivity.corner = 0;
        //reset end game storage
        mainActivity.partial = false;
        mainActivity.full = false;
        mainActivity.hang = false;

        //update values
        mainActivity.updateTotal();
        mainActivity.setTitleScore();
        update();
    }


}
