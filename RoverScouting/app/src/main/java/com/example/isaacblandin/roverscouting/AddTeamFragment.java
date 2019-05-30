package com.example.isaacblandin.roverscouting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Fragment used to add a team and stats to the team list
 */
public class AddTeamFragment extends Fragment {

    //auto variables
    private boolean landed;
    private boolean sampled;
    private boolean claimed;
    private boolean parked;

    //teleop variables
    private int landerMinerals = 0 ;

    //endgame variables
    private boolean endpark;
    private boolean latched;

    //sub totals
    private int autoTotal = 0;
    private int teleTotal = 0;
    private int endTotal = 0;

    //total variable
    private int total = 0;

    //ui element declaration
    TextView score;
    TextView landMinerals;
    Button landInc;
    Button landDec;
    Button send;
    EditText teamNum;
    EditText teamNameText;

    //team number
    private String teamNumber;

    //team name
    private String teamName;

    private OnFragmentInteractionListener mListener;

    public AddTeamFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    /**
     * Creates the ui of the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragment = inflater.inflate(R.layout.fragment_add_team, container, false);


        //initializing buttons
        ToggleButton landedButton = (ToggleButton) myFragment.findViewById(R.id.landed);
        ToggleButton sampledButton = (ToggleButton) myFragment.findViewById(R.id.sampled);
        ToggleButton markerButton = (ToggleButton) myFragment.findViewById(R.id.teamMarker);
        ToggleButton parkedButton = (ToggleButton) myFragment.findViewById(R.id.parked);

        ToggleButton endParkButton = (ToggleButton) myFragment.findViewById(R.id.EndParked);
        ToggleButton endLatchButton = (ToggleButton) myFragment.findViewById(R.id.Latched);

        //handle landing button
        landedButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    landed = true;
                } else {
                    landed = false;
                }
                updateScore();
            }
        });

        //handle sampling button
        sampledButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    sampled = true;
                } else {
                    sampled = false;
                }

                updateScore();
            }
        });

        //handle marker button
        markerButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    claimed = true;
                } else {
                    claimed = false;
                }

                updateScore();
            }
        });

        //handle parked button
        parkedButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    parked = true;

                } else {
                    parked = false;
                }

                updateScore();
            }
        });

        //handle end game park button
        endParkButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    endpark = true;

                } else {
                    endpark = false;
                }

                updateScore();
            }
        });

        //handle latched button
        endLatchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    latched = true;

                } else {
                    latched = false;
                }

                updateScore();
            }
        });

        //handle add and subtract mineral buttons
        landInc = (Button) myFragment.findViewById(R.id.landAdd);
        landInc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                addLandMineral();
            }
        });

        landDec = (Button) myFragment.findViewById(R.id.landSub);
        landDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLandMineral();
            }
        });

        send = (Button) myFragment.findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {sendTeam();}
        });

        score = (TextView) myFragment.findViewById(R.id.totalAuto);
        landMinerals = (TextView) myFragment.findViewById(R.id.landMinerals);

        teamNum = (EditText) myFragment.findViewById(R.id.editText);

        teamNameText = (EditText) myFragment.findViewById(R.id.editText2);

        // Inflate the layout for this fragment
        return myFragment;

    }

    //add one mineral to the counter
    private void addLandMineral(){
        landerMinerals ++;
        updateScore();
    }

    //subtract one mineral from the counter
    private void subLandMineral(){
        landerMinerals --;
        updateScore();
    }

    /**
     * updates the total score variables
     */
    private void updateScore(){
        int temp = 0;
        if (landed){
            temp += 30;
        }
        if (sampled){
            temp += 25;
        }
        if (claimed){
            temp += 15;
        }
        if (parked){
            temp += 10;
        }

        autoTotal = temp;

        temp += landerMinerals * 5;
        teleTotal = landerMinerals * 5;

        if (latched){
            temp += 50;
            endTotal = 50;
        } else if (endpark){
            temp += 20;
            endTotal = 20;
        }

        total = temp;
        score.setText( "" + total);

        landMinerals.setText("" + landerMinerals);
    }

    /**
     * sends stats to a team object and then the team list
     */
    public void sendTeam(){
        teamNumber = teamNum.getText().toString();
        teamName = teamNameText.getText().toString();

        TeamItem a = new TeamItem(teamNumber, teamName);

        a.setLands(landed);
        a.setSamples(sampled);
        a.setClaims(claimed);
        a.setParks(parked);

        a.setLanderMinerals(landerMinerals);

        a.setEndPark(endpark);
        a.setLatch(latched);

        a.setScoutAuto(autoTotal);
        a.setScoutTele(teleTotal);
        a.setScoutEnd(endTotal);
        a.setScoutTotal(total);


        TeamList.addItem(a);

        Fragment nextFrag= new AddTeamFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Used to interact with the main activity
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
