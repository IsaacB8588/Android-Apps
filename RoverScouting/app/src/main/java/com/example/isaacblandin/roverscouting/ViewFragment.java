package com.example.isaacblandin.roverscouting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A Fragment which displays a team's full stats
 * in a presentable manner.
 * Accessed by being selected in Team List Fragment
 */
public class ViewFragment extends Fragment {

    private TeamItem selectedTeam;

    TextView teamName;
    TextView teamNumber;
    TextView total;

    TextView auto;
    TextView lands;
    TextView samples;
    TextView claims;
    TextView parks;

    TextView tele;
    TextView minerals;

    TextView end;
    TextView endParks;
    TextView latches;

    private OnFragmentInteractionListener mListener;


    /**
     * required empty constructor
     */
    public ViewFragment() {
    }

    /**
     * allows activity to pass a team object to the fragment as an argument
     * @param team
     * @return a fragment with the stores arguements
     */
    public static ViewFragment newInstance(TeamItem team) {
        ViewFragment fragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putSerializable("Team", team);
        fragment.setArguments(args);
        return fragment;
    }

    //pulls newInstance Values
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedTeam = (TeamItem) getArguments().getSerializable("Team");
        }
    }

    /**
     * creates the view of the fragment and initializes value of textViews

     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return fragment view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        teamName = (TextView)view.findViewById(R.id.name);
        teamNumber = (TextView)view.findViewById(R.id.number);

        total = (TextView)view.findViewById(R.id.total);

        auto = (TextView)view.findViewById(R.id.auto);
        lands = (TextView)view.findViewById(R.id.lands);
        samples = (TextView)view.findViewById(R.id.samples);
        claims = (TextView)view.findViewById(R.id.claims);
        parks = (TextView)view.findViewById(R.id.parks);

        tele = (TextView)view.findViewById(R.id.tele);
        minerals = (TextView)view.findViewById(R.id.minerals);

        end = (TextView)view.findViewById(R.id.end);
        endParks = (TextView)view.findViewById(R.id.parksEnd);
        latches = (TextView)view.findViewById(R.id.latches);

        teamName.setText(selectedTeam.getContent());
        teamNumber.setText(selectedTeam.getId());

        total.setText("Total: " + selectedTeam.getScoutTotal());

        auto.setText("Auto Score: " + selectedTeam.getScoutAuto());
        lands.setText("Lands: " + selectedTeam.isLands());
        samples.setText("Samples: " + selectedTeam.isSamples());
        claims.setText("Claims: " + selectedTeam.isClaims());
        parks.setText("Parks: " + selectedTeam.isParks());

        tele.setText("TeleOp Score: " + selectedTeam.getScoutTele());
        minerals.setText("Lander Minerals: " + selectedTeam.getLanderMinerals());

        end.setText("End Total: " + selectedTeam.getScoutEnd());
        endParks.setText("Parks: " + selectedTeam.isParks());
        latches.setText("Latches: " + selectedTeam.isLatch());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
     * Used to interact back to the main activity
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
