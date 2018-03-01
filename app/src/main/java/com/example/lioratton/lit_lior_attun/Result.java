package com.example.lioratton.lit_lior_attun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView grade;
    ImageView[] answers=new ImageView[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        grade=(TextView) findViewById(R.id.grade);
        answers[0]=(ImageView) findViewById(R.id.a1);
        answers[1]=(ImageView) findViewById(R.id.a2);
        answers[2]=(ImageView) findViewById(R.id.a3);
        answers[3]=(ImageView) findViewById(R.id.a4);
        answers[4]=(ImageView) findViewById(R.id.a5);
        answers[5]=(ImageView) findViewById(R.id.a6);
        answers[6]=(ImageView) findViewById(R.id.a7);
        answers[7]=(ImageView) findViewById(R.id.a8);
        answers[8]=(ImageView) findViewById(R.id.a9);
        answers[9]=(ImageView) findViewById(R.id.a10);

        Intent gt=getIntent();
        int points=gt.getIntExtra("points", 0);
        boolean[] correct=gt.getBooleanArrayExtra("correct");
        grade.setText(""+points);

        for (int i=0; i<correct.length; i++)
        {
            if (correct[i])
                answers[i].setImageResource(R.drawable.vi);
        }
    }

    public void back(View view) {
        Intent t=new Intent(this, Main.class);
        startActivity(t);
    }
}
