package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    int buttonCount;
    CountDownTimer cDT;
    TextView timerTextView;
    TextView scoreTextView;
    TextView equationTextView;
    TextView resultTextView;
    int opr1,opr2,total,opt2,winCount=0,attempt=0;
    GridLayout gridLayout;
    boolean ans=false;
    Button b3;
    Button b4;


    public void buttonClick(View view)
    {
        button=(Button) view;
        buttonCount=Integer.parseInt(button.getTag().toString());

        attempt++;
        checkerSystem();
        scoreTextView.setText(Integer.toString(winCount)+"/"+Integer.toString(attempt));
        randomNumberGenerator();
        total=opr1+opr2;
        equationTextView.setText(opr1 + " + " + opr2);
        fillPositions(total);

    }
    public void goButton(View view)
    {
        resultTextView.setVisibility(View.VISIBLE);
        equationTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        b4.setVisibility(View.INVISIBLE);
        cDT.start();

    }

    public void playAgain(View view){


        winCount=0;
        attempt=0;
        scoreTextView.setText("");
        equationTextView.setText("");
        resultTextView.setText("");
        randomNumberGenerator();
        total=opr1+opr2;
        equationTextView.setText(opr1 + " + " + opr2);
        fillPositions(total);
        b3.setVisibility(View.INVISIBLE);
        cDT.start();



    }
    public void checkerSystem()
    {
        ans=false;
        if(buttonCount==1)
        {
            if(button.getText().equals(Integer.toString(total))){
                ans=true;
            }
        }
        else if(buttonCount==2)
        {
            if(button.getText().equals(Integer.toString(total))){
                ans=true;
            }
        }
        else if(buttonCount==3)
        {
            if(button.getText().equals(Integer.toString(total))){
                ans=true;
            }
        }
        else if(buttonCount==4)
        {
            if(button.getText().equals(Integer.toString(total))){
                ans=true;
            }
        }

        if(ans)
        {
            winCount++;
            resultTextView.setText("Correct");
        }
        else
        {
            resultTextView.setText("Wrong");
        }
    }
    public void randomNumberGenerator()
    {
        Random rand = new Random();
        opr1= rand.nextInt(20) + 1;
        opr2=rand.nextInt(15) + 1;


    }

    public void fillPositions(int c){
        Random rand1= new Random();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (arrayList.size() < 5) {
            int a = rand1.nextInt(34)+1;

            if (!arrayList.contains(a) && a!=total) {
                arrayList.add(a);
            }
        }

        for(int i=0; i<gridLayout.getChildCount(); i++) {

            Button b = (Button) gridLayout.getChildAt(i);

            b.setText(Integer.toString(arrayList.get(i)));

        }

        opt2= rand1.nextInt(4);
        Button b2= (Button) gridLayout.getChildAt(opt2);
        b2.setText(Integer.toString(c));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView= findViewById(R.id.timerTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        equationTextView=findViewById(R.id.equationTextView);
        resultTextView=findViewById(R.id.resultTextView);
        gridLayout=findViewById(R.id.gridLayout);
        b3=findViewById(R.id.button5);
        b4=findViewById(R.id.goButton);

        randomNumberGenerator();
        total=opr1+opr2;
        equationTextView.setText(opr1 + " + " + opr2);
        fillPositions(total);




        cDT=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(millisUntilFinished/1000 +"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Time Up!");
                b3.setVisibility(View.VISIBLE);

            }
        };

    }
}