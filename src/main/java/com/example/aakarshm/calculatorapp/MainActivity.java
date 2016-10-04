package com.example.aakarshm.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4, textView5;
    Button button1;
    EditText editText1, editText2, editText3;
    RelativeLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textviews/butttons... are all in order of which they are on the layout.
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        button1.setOnClickListener(buttonListener);

    }

    public View.OnClickListener buttonListener = new View.OnClickListener() {
    public void onClick (View view){
        MainActivity main = new MainActivity();
        String baseStr = editText1.getText().toString();
        String expStr = editText2.getText().toString();
        String modStr = editText3.getText().toString();
        long base = Long.parseLong(baseStr);
        long exp = Long.parseLong(expStr);
        long mod = Long.parseLong(modStr);
        long answer = main.computeMod(base, exp, mod);
        textView5.setText(baseStr + " ^ " + expStr + " (mod " + modStr + " ) = " + Long.toString(answer));


    }};


    public long computeMod (long a, long b, long m) {
        if(b==2) return (a*a)%m;

        if(b==1) return a%m;

        if(a%m == 0) return 0;


        if (b % 2 == 0) {

            return computeMod(a*a%m,b/2, m)%m;
        }

        else {
            return a % m * computeMod(a*a%m, (b - 1) / 2, m)%m;

        }

    }
}


