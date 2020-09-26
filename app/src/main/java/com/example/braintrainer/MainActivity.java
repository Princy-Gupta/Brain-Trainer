package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
 Button b,b1,b2,b3,b4;
 ArrayList<Integer> answers = new ArrayList<>();
 TextView result;
 int loc;
 TextView pts;
 Button playagain;
 ConstraintLayout cl;

 int score=0;
 int num=0;
    TextView sum;
    TextView timer;
    public void start (View view)
    {
    b.setVisibility(View.INVISIBLE);
    cl.setVisibility(View.VISIBLE);
        playagain(playagain);


    }
    public  void playagain(View view)
    {
        score=0;
        num=0;
        timer.setText("30s");
        pts.setText("0/0");
        result.setText("");
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        playagain.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(Long.toString(l/1000)+ "s");

            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);

                timer.setText("0s");
                result.setText("Your score: "+Integer.toString(score)+"/" + Integer.toString(num));
            }
        }.start();
    }
    public void chooseans(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(loc)))
        {
           score++;
            result.setText("Correct!");
        }
        else
        {
            result.setText("Incorrect!");
        }
        num++;
        pts.setText(Integer.toString(score)+"/" + Integer.toString(num));
        generateQuestion();
    }
    public void generateQuestion()
    {
        Random rand= new Random();
        int a= rand.nextInt(51);
        int c= rand.nextInt(51);
        sum.setText(Integer.toString(a)+" + " + Integer.toString(c));
        loc=rand.nextInt(4);
        answers.clear();
        int incorrect;
        for(int i=0;i<4;i++)
        {
            if(i==loc)
            {
                answers.add(a+c);
            }
            else {
                incorrect=rand.nextInt(101);
                while(incorrect== a+c)
                {
                    incorrect=rand.nextInt(101);
                }
                answers.add(incorrect);
            }
        }
        b1.setText(Integer.toString(answers.get(0)));
        b2.setText(Integer.toString(answers.get(1)));
        b3.setText(Integer.toString(answers.get(2)));
        b4.setText(Integer.toString(answers.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       b= findViewById(R.id.go);
        sum= (TextView) findViewById(R.id.textView3);
         b1= (Button)findViewById(R.id.button1);
         b2= (Button)findViewById(R.id.button2);
         b3= (Button)findViewById(R.id.button3);
        b4= (Button)findViewById(R.id.button4);
        timer= (TextView) findViewById(R.id.timer);
        result= (TextView)findViewById(R.id.result);
        pts= (TextView)findViewById(R.id.textView2);
        playagain= (Button)findViewById(R.id.button7);
        cl= findViewById(R.id.layout);



    }
}