package com.example.isaacblandin.roverruckusscoring;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeleOpFragment extends Fragment {


    TextView goldAmount;
    TextView silverAmount;
    TextView cornerAmount;
    TextView teleOpScore;

    Button goldAddBtn;
    Button goldSubBtn;
    Button silverAddBtn;
    Button silverSubBtn;
    Button cornerAddBtn;
    Button cornerSubBtn;

    public int goldVar;
    public int silverVar;
    public int cornerVar;

    public int teleOpScoreFrag;

    public MainActivity mainActivity;


    public TeleOpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        View myFragment = inflater.inflate(R.layout.fragment_tele_op, container, false);

        goldAmount = (TextView) myFragment.findViewById(R.id.goldNum);
        silverAmount = (TextView) myFragment.findViewById(R.id.silverNum);
        cornerAmount = (TextView) myFragment.findViewById(R.id.cornerNum);

        teleOpScore = (TextView) myFragment.findViewById(R.id.teleOpScore);

        goldVar = mainActivity.gold;
        silverVar = mainActivity.silver;
        cornerVar = mainActivity.corner;

        teleOpScoreFrag = mainActivity.teleOpScore;

        updateValues();

        goldAddBtn = (Button) myFragment.findViewById(R.id.goldAdd);
        goldAddBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                goldAdd();
            }
        });

        goldSubBtn = (Button) myFragment.findViewById(R.id.goldSub);
        goldSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goldSub();
            }
        });

        silverAddBtn = (Button) myFragment.findViewById(R.id.silverAdd);
        silverAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                silverAdd();
            }
        });

        silverSubBtn = (Button) myFragment.findViewById(R.id.silverSub);
        silverSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                silverSub();
            }
        });

        cornerAddBtn = (Button) myFragment.findViewById(R.id.cornerAdd);
        cornerAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cornerAdd();
            }
        });

        cornerSubBtn = (Button) myFragment.findViewById(R.id.cornerSub);
        cornerSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cornerSub();
            }
        });


        // Inflate the layout for this fragment
        return myFragment;
    }

    public void updateValues(){
        goldAmount.setText("" + goldVar);
        silverAmount.setText("" + silverVar);
        cornerAmount.setText("" + cornerVar);

        teleOpScore.setText("" + teleOpScoreFrag);

        mainActivity.gold = goldVar;
        mainActivity.silver = silverVar;
        mainActivity.corner = cornerVar;

        mainActivity.teleOpScore = teleOpScoreFrag;

        mainActivity.updateTotal();
    }

    public void goldAdd() {
        goldVar ++;
        teleOpScoreFrag += 5;
        updateValues();
    }

    public void goldSub(){
        goldVar --;
        teleOpScoreFrag -= 5;
        updateValues();
    }

    public void silverAdd(){
        silverVar ++;
        teleOpScoreFrag += 5;
        updateValues();
    }

    public void silverSub(){
        silverVar --;
        teleOpScoreFrag -= 5;
        updateValues();
    }

    public void cornerAdd(){
        cornerVar ++;
        teleOpScoreFrag += 2;
        updateValues();
    }

    public void cornerSub(){
        cornerVar --;
        teleOpScoreFrag -= 2;
        updateValues();
    }

}
