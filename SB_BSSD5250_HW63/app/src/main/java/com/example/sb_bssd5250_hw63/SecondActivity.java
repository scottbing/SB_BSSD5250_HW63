package com.example.sb_bssd5250_hw63;

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

public class SecondActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LinearLayout buttonLL = new LinearLayout(this);

        Button google = new Button(this);
        google.setText("Google");
        google.setOnClickListener(googleListener);

        Button elgoog = new Button(this);
        elgoog.setText("elgoog");
        elgoog.setOnClickListener(elgoogListener);

        buttonLL.addView(google);
        buttonLL.addView(elgoog);

        constraintLayout = (ConstraintLayout) findViewById(R.id.second_layout);
        constraintLayout.addView(buttonLL);
        constraintLayout.setBackgroundColor(Color.GREEN);
    }

    private View.OnClickListener googleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse("https://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //intent.setType("text/plain");
            List<ResolveInfo> possibleActivitiesList = getPackageManager()
                    .queryIntentActivities(intent, PackageManager.MATCH_ALL);
            Log.d("NMB01", String.valueOf(intent.resolveActivity(getPackageManager())));
            if(possibleActivitiesList.size() >1) {
                String title = "Open this site with:";
                Intent chooser = Intent.createChooser(intent,title);
                startActivity(chooser);
            } else if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    };

    private View.OnClickListener elgoogListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse("http://elgoog.im");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //intent.setType("text/plain");
            List<ResolveInfo> possibleActivitiesList = getPackageManager()
                    .queryIntentActivities(intent, PackageManager.MATCH_ALL);
            Log.d("NMB01", String.valueOf(intent.resolveActivity(getPackageManager())));
            if(possibleActivitiesList.size() >1) {
                String title = "Open this site with:";
                Intent chooser = Intent.createChooser(intent,title);
                startActivity(chooser);
            } else if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    };
}
