package com.example.isaacblandin.roverruckusscoring;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class EndGameFragment extends Fragment {


    public EndGameFragment() {
        // Required empty public constructor
    }

    MainActivity mainActivity;
    public int endGameScoreFrag;
    TextView score;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragment = inflater.inflate(R.layout.fragment_end_game, container, false);
        mainActivity = (MainActivity) getActivity();

        score = (TextView)myFragment.findViewById(R.id.scoreText);
        endGameScoreFrag = mainActivity.endGameScore;
        updateEndGame();

        ToggleButton partialPark = (ToggleButton)myFragment.findViewById(R.id.partButton);
        ToggleButton fullPark = (ToggleButton) myFragment.findViewById(R.id.fullButton);
        ToggleButton hanging = (ToggleButton) myFragment.findViewById(R.id.hangButton);

        Button pageOpen = (Button) myFragment.findViewById(R.id.scoreSummary);

        if (mainActivity.partial){
            partialPark.toggle();
        }
        if (mainActivity.full){
            fullPark.toggle();
        }
        if (mainActivity.hang){
            hanging.toggle();
        }

        partialPark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    endGameScoreFrag += 15;
                    mainActivity.partial = true;
                } else {
                    endGameScoreFrag -= 15;
                    mainActivity.partial = false;
                }

                updateEndGame();
            }
        });

        fullPark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    endGameScoreFrag += 25;
                    mainActivity.full = true;
                } else {
                    endGameScoreFrag -= 25;
                    mainActivity.full = false;
                }

                updateEndGame();
            }
        });

        hanging.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    endGameScoreFrag += 50;
                    mainActivity.hang = true;
                } else {
                    endGameScoreFrag -= 50;
                    mainActivity.hang = false;
                }

                updateEndGame();
            }
        });

        pageOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.loadFragment(new ScoreFragment());
            }
        });

        // Inflate the layout for this fragment
        return myFragment;
    }

    public void updateEndGame(){
        score.setText("" + endGameScoreFrag);
        mainActivity.endGameScore = endGameScoreFrag;
        mainActivity.updateTotal();
    }

}
