package com.example.sb_bssd5250_hw63;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private int color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout buttonLL = new LinearLayout(this);
        buttonLL.setOrientation(LinearLayout.VERTICAL);

        Button internetThings = new Button(this);
        internetThings.setText("Internet");
        internetThings.setOnClickListener(internetListener);

        Button pickColorButton = new Button(this);
        pickColorButton.setText("Color Picker");
        pickColorButton.setOnClickListener(pickColorListener);

        Button portfolio = new Button(this);
        portfolio.setText("Portfolio");
        portfolio.setOnClickListener(portfolioListener);

        buttonLL.addView(pickColorButton);
        buttonLL.addView(internetThings);
        buttonLL.addView(portfolio);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.main_layout);
        constraintLayout.addView(buttonLL);
        constraintLayout.setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode ==1) {
            ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.main_layout);
            int color = data.getIntExtra("color",0);
            constraintLayout.setBackgroundColor(color);   // Third Activity dictates background color

        }

    }

    private final View.OnClickListener pickColorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent passableData = new Intent(getApplicationContext(), ThirdActivity.class);
            passableData.putExtra("color", color);
            startActivityForResult(passableData, 1);
        }
    };

    private View.OnClickListener internetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);

        }
    };

    private View.OnClickListener portfolioListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
            startActivity(intent);

        }
    };
}
