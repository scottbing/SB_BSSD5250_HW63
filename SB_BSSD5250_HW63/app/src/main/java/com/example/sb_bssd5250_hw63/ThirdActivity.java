package com.example.sb_bssd5250_hw63;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private RadioButton rb1,rb2,rb3;
    private RadioGroup rg;
    private int color;

    // Code built from:
    // https://www.android-examples.com/create-radiogroup-dynamically-in-android-with-radio-button/https://www.android-examples.com/create-radiogroup-dynamically-in-android-with-radio-button/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        LinearLayout buttonLL = new LinearLayout(this);

        // setup the radio group
        RadioGroup rg;

        // set up the three buttons
        rg = new RadioGroup(this);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);
        rb3 = new RadioButton(this);

        // set up the labels
        rb1.setText("Red");
        rb2.setText("Green");
        rb3.setText("Blue");

        // add buttons to group
        rg.addView(rb1);
        rg.addView(rb2);
        rg.addView(rb3);

        // make everything look pretty
        LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rg.setLayoutParams(layoutparams);

        // add radio group to layout
        buttonLL.addView(rg);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.third_layout);
        constraintLayout.addView(buttonLL);
        constraintLayout.setBackgroundColor(Color.BLUE);

        // set up listener
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rb1.isChecked()) // Red
                {
                    Toast.makeText(ThirdActivity.this,"Color Red Selected" , Toast.LENGTH_LONG).show();
                    color = Color.RED;
                }


                if(rb2.isChecked()) // Green
                {
                    Toast.makeText(ThirdActivity.this,"Color Green Selected" , Toast.LENGTH_LONG).show();
                    color= Color.GREEN;
                }


                if(rb3.isChecked()) // Blue
                {
                    Toast.makeText(ThirdActivity.this,"Color Blue Selected" , Toast.LENGTH_LONG).show();
                    color = Color.BLUE;
                }
                /*Intent passableData = new Intent(getApplicationContext(), MainActivity.class);
                passableData.putExtra( "color", color);
                startActivityForResult(passableData, 1);
                setResult(RESULT_OK,passableData);*/
                Intent passableData = new Intent();
                passableData.putExtra( "color", color);
                setResult(RESULT_OK,passableData);
                finish();
            }
        });
    }
}
