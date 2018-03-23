package com.example.lioratton.lit_lior_attun;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IntegerRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    TextView question;
    int qnum;
    int points;
    Spinner answers;
    boolean[] correct;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(115,39,178)));

        question=(TextView)findViewById(R.id.question);
        answers=(Spinner) findViewById(R.id.answers);

        Intent gt=getIntent();
        points=gt.getIntExtra("points", 0);
        qnum=gt.getIntExtra("qnum", 1);
        correct=gt.getBooleanArrayExtra("correct");
        if (correct==null)
            correct=new boolean[10];

        String packageName = getPackageName();
        int resId = getResources().getIdentifier("q"+qnum, "array", packageName);

        adapter=ArrayAdapter.createFromResource(this, resId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answers.setAdapter(adapter);

        answers.setBackgroundColor(Color.WHITE);

        String q="אלברט המלך";

        switch (qnum)
        {
            case 1: q="מה הפירוש המטאפורי של השורה רְאִי אֲדָמָה, כִּי הָיִינוּ בַּזְבְּזָנִים עַד מְאֹד?";break;
            case 2: q="מהם האורות הרחוקים עליהם מדברת רחל בשיר רק על עצמי?"; break;
            case 3: q="מדוע משתמשת המשוררת במילים-ותמתק דקיתם-איך דקירה יכולה להיות מתוקה?"; break;
            case 4: q="מה משמעות הביטוי-ארג יומם עוד שתי-בשיר ראי אדמה?"; break;
            case 5: q="למה מתכוונת רחל במשפטה-גם משאי עמסתי כמוה רב וכבד מכתפי הדלה-?"; break;
            case 6: q="מדוע נכתב השיר-האומנם עוד יבואו ימים-?"; break;
            case 7: q="מהו הנמשל בשורה הזו בשיר ראי אדמה-מצניע חן עם יפה קלח,קטורת כוסו נכונה-?"; break;
            case 8: q="למה מתכוונת רחל בדימוייה-יד ענקים זדונה ובוטחת-?"; break;
            case 9: q="מהי לבסוף תקוותו של טשרניחובסקי בשיר ראי אדמה?"; break;
            case 10: q="מהי משמעות החזרה על המילה-ומותר-בשיר האומנם עוד יבואו ימים?"; break;
        }
        question.setText(q);
    }

    public void next(View view) {
        //Check if the answer is correct.
        String packageName = getPackageName();
        int resId = getResources().getIdentifier("a"+qnum, "string", packageName);
        int corr= Integer.parseInt(getString(resId));
        resId = getResources().getIdentifier("q"+qnum, "array", packageName);
        String ans=getResources().getStringArray(resId)[corr];
        if (ans.equals(answers.getSelectedItem())) {
            points += 10;
            correct[qnum-1]=true;
        }

        Intent t=null;
        if (qnum==10)
            t=new Intent(this, Result.class);
        else
            t=new Intent(this, Test.class);
        t.putExtra("qnum", qnum+1);
        t.putExtra("points", points);
        t.putExtra("correct", correct);

        startActivity(t);
    }
}
