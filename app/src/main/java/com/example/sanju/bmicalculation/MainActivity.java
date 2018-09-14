package com.example.sanju.bmicalculation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    double bmi=0.0,w,h;
    String r;
    public void bmifun(View v){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        EditText Height=(EditText) findViewById(R.id.input1);
                if(Height.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"please enter the height",Toast.LENGTH_SHORT).show();
                }else {
                    String he=Height.getText().toString();
                     h = Float.parseFloat(he);
                    h=h*0.01;
        EditText Weight=(EditText) findViewById(R.id.input2);
        if(Weight.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"please enter the weight",Toast.LENGTH_SHORT).show();
        }else{
            String we=Weight.getText().toString();
            w=Float.parseFloat(we);
        bmi=w/(h*h);
        r="Your BMI is"+String.valueOf(bmi);
        if(bmi<18.5) {
            r += "\nHey! You're in the UnderWeight category. ";
        }
        else if(bmi<24.9 && bmi>=18.5){
            r+="\nHey! You're in the Normal category. Keep it up.";
        }

        else if(bmi>=24.9 && bmi<=30)
        {
            r+="\nHey! You're in the Overweight category. \nDo exercise and stay fit.";
        }
        else if(bmi>30) {
            r += "\nHey! You're in the Obese category. \nDo exercise and stay fit.";
        }
        TextView re=(TextView) findViewById(R.id.result);
                re.setText(r);
    }}}
    public void again(View v){
        TextView re=(TextView) findViewById(R.id.result);
        re.setText("");
    }
}
