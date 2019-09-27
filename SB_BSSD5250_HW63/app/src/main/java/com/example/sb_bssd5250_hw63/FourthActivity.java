package com.example.sb_bssd5250_hw63;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button changeActivityButton = new Button(this);
        changeActivityButton.setText("Change Activity");
        changeActivityButton.setOnClickListener(changeActivityListener);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.second_layout);
        constraintLayout.addView(changeActivityButton);
        constraintLayout.setBackgroundColor(Color.YELLOW);

    }

    private View.OnClickListener changeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent dataSent = getIntent();
            TextView messageText = (TextView) findViewById(R.id.message_text);
            messageText.setText(dataSent.getStringExtra("message"));

            Intent passableData = new Intent();
            passableData.putExtra("message", "bye");
            setResult(RESULT_OK,passableData);

            finish();
        }
    };
}
