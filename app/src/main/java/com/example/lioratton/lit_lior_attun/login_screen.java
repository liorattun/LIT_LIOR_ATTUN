package com.example.lioratton.lit_lior_attun;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class login_screen extends AppCompatActivity {
    String st;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        et = (EditText) findViewById(R.id.et);

        boolean exists=true;

            InputStream is=null;
            try {
                is=openFileInput("name.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                exists=false;
            }
            if (exists)
            {
                InputStreamReader tmp=new InputStreamReader(is);
                BufferedReader reader=new BufferedReader(tmp);
                String str="";
                StringBuffer buffer=new StringBuffer();

                try {
                    while((str=reader.readLine())!=null)
                        buffer.append(str+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent t=new Intent(this, Main.class);
                t.putExtra("aaa", ""+buffer);
                startActivity(t);
            }
    }

    public void pr(View view) {
        st = et.getText().toString();
        if (st.equals("")) {
            Toast.makeText(this, "אנא הכנס קלט", Toast.LENGTH_SHORT).show();
        } else {
            FileOutputStream fos=null;
            try {
                fos=openFileOutput("name.txt", Context.MODE_PRIVATE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            BufferedWriter bw=new BufferedWriter(osw);
            try {
                bw.write(st);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent it = new Intent(this, Main.class);
            it.putExtra("aaa", st);
            startActivity(it);
        }
    }
}