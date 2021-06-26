package com.evanxu.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        CardView wageCalculatorCard;
        CardView triangleCheckerCard;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wageCalculatorCard = findViewById(R.id.card_view_wage_calculator);
        triangleCheckerCard = findViewById(R.id.card_view_triangle_checker);
        TextView emailTextView = findViewById(R.id.text_view_email_address);

        // Set up intent activity to enter wage calculator layout
        wageCalculatorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wageCalculatorIntent = new Intent(MainActivity.this, WageCalculatorActivity.class);
                startActivity(wageCalculatorIntent);
            }
        });

        // Set up intent activity to enter wage calculator layout
        triangleCheckerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent triangleCheckerIntent = new Intent(MainActivity.this, TriangleCheckerActivity.class);
                startActivity(triangleCheckerIntent);
            }
        });

        // Set up explicit intent activity to enter wage calculator layout
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailto: evan.qin.xu@gmail.com"));
                startActivity(launchEmailAppIntent);
            }
        });
    }
}