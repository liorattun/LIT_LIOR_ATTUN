package com.example.lioratton.lit_lior_attun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    String st;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        Intent it = getIntent();
        st = it.getStringExtra("aaa");
        tv.setText("שלום  " + st + "  ברוכים הבאים לאפליקציית");
    }

    public void press1(View view) {
        Intent t = new Intent(this, Haomnam.class);
        startActivity(t);
    }

    public void press2(View view) {
        Intent t = new Intent(this,Adama.class);
        startActivity(t);
    }

    public void press4(View view) {
        Intent t=new Intent(this, Test.class);
        startActivity(t);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("Credits");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent t=new Intent(this, Credits.class);
        startActivity(t);

        return true;
    }
}
