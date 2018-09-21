package com.example.isaacblandin.roverruckusscoring;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AutoFragment extends Fragment {


    public AutoFragment() {
        // Required empty public constructor
    }


    public int autoScoreFrag;

    TextView score;


    public MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        View myFragment = inflater.inflate(R.layout.fragment_auto, container, false);

        score = (TextView) myFragment.findViewById(R.id.totalAuto);
        autoScoreFrag = mainActivity.autoScore;
        updateScore();

        //assign the toggle buttons
        ToggleButton landedButton = (ToggleButton) myFragment.findViewById(R.id.landed);
        ToggleButton sampledButton = (ToggleButton) myFragment.findViewById(R.id.sampled);
        ToggleButton markerButton = (ToggleButton) myFragment.findViewById(R.id.teamMarker);
        ToggleButton parkedButton = (ToggleButton) myFragment.findViewById(R.id.parked);

        if (mainActivity.landed){
            landedButton.toggle();
        }
        if (mainActivity.sampled){
            sampledButton.toggle();
        }
        if (mainActivity.marker){
            markerButton.toggle();
        }
        if (mainActivity.parked){
            parkedButton.toggle();
        }


        landedButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    autoScoreFrag += 30;
                    mainActivity.landed = true;
                } else {
                    autoScoreFrag -= 30;
                    mainActivity.landed = false;
                }

                updateScore();
            }
        });

        sampledButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    autoScoreFrag += 25;
                    mainActivity.sampled = true;
                } else {
                    autoScoreFrag -= 25;
                    mainActivity.sampled = false;
                }

                updateScore();
            }
        });

        markerButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    autoScoreFrag += 15;
                    mainActivity.marker = true;
                } else {
                    autoScoreFrag -= 15;
                    mainActivity.marker = false;
                }

                updateScore();
            }
        });

        parkedButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    autoScoreFrag += 10;
                    mainActivity.parked = true;
                } else {
                    autoScoreFrag -= 10;
                    mainActivity.parked = false;
                }

                updateScore();
            }
        });
        // Inflate the layout for this fragment
        return myFragment;
    }

    public void updateScore(){
        score.setText("" + autoScoreFrag);
        mainActivity.autoScore = autoScoreFrag;
        mainActivity.updateTotal();
    }

}
