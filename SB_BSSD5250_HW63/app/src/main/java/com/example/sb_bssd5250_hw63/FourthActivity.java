package com.example.sb_bssd5250_hw63;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Stack;

public class FourthActivity extends AppCompatActivity {
    private LinearLayout upperLayout;
    private LinearLayout lowerLayout;
    private Stack<ImageButton> gbStack;
    private char green = 'g';
    private char red = 'r';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        gbStack = new Stack<>(); // establish the green button stack

        upperLayout = (LinearLayout) findViewById(R.id.upperlayout);
        lowerLayout = (LinearLayout) findViewById(R.id.lowerlayout);
        ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(gbClickedListener);
        imgButton.setLayoutParams( new LinearLayout.LayoutParams(
                75, 75));

    }

    // When a green button is pressed, a new red button will be added  to the
    // bottom linear layout and a new green button added to the top linear layout.
    private View.OnClickListener gbClickedListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            // When a green button is pressed, a new red button will be added to the bottom
            // linear layout and a new green button added to the top linear layout.
            //((ViewManager)view.getParent()).removeView(view);
            lowerLayout.addView(CreateImageButton(red));
            upperLayout.addView(CreateImageButton(green));

        }
    };

    // When a red button is pressed, a green button will be removed from the top linearlayout.
    private View.OnClickListener rbClickedListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            // got Java stack implementation from JournalDev article
            // https://www.journaldev.com/13401/java-stack
            // When a red button is pressed, a green button will be removed from the top linearlayout.

            // pop from non-empty stack
            if (!gbStack.isEmpty()) {
                upperLayout.removeView(gbStack.pop());
            }
        }
    };

    // ImageButton Factory Method
    private ImageButton CreateImageButton(char color) {
        ImageButton imgButton;
        imgButton = new ImageButton(this);
        imgButton.setBackground(null);
        if (color == 'g') {
            imgButton.setImageResource(R.drawable.green);
            imgButton.setOnClickListener(gbClickedListener);
        }
        if (color == 'r') {
            imgButton.setImageResource(R.drawable.red);
            imgButton.setOnClickListener(rbClickedListener);
        }
        imgButton.setLayoutParams( new LinearLayout.LayoutParams(
                75, 75));
        // push it on the stack
        gbStack.push((ImageButton)imgButton);
        return imgButton;
    }
}
