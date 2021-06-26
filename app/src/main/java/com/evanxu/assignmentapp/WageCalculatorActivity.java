package com.evanxu.assignmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class WageCalculatorActivity extends AppCompatActivity {

    private EditText hourlyRateView;
    private EditText regularHoursView;
    private EditText overtimeHoursView;
    private TextView resultView;
    private Button calculateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wage_calculator);

        findViews();
        setUpButtonClickListener();
    }

    private void findViews() {
        hourlyRateView = findViewById(R.id.edit_text_hourly_rate);
        regularHoursView = findViewById(R.id.edit_text_regular_hours);
        overtimeHoursView = findViewById(R.id.edit_text_overtime_hours);
        resultView = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
    }

    // function to run when calculate button is clicked
    private void setUpButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weeklyPay = calculateWeeklyPay();

                displayResult(weeklyPay);

            }
        });
    }

    // calculate weekly pay based on the input values
    private double calculateWeeklyPay() {
        String hourlyRateText = hourlyRateView.getText().toString();
        String regularHoursText = regularHoursView.getText().toString();
        String overtimeHoursText = overtimeHoursView.getText().toString();

        if (hourlyRateText.isEmpty() || regularHoursText.isEmpty() || overtimeHoursText.isEmpty()) {
            Toast.makeText(this, "Please fill out all values", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            double hourlyRate = Double.parseDouble(hourlyRateText);
            double regularHours = Double.parseDouble(regularHoursText);
            double overtimeHours = Double.parseDouble(overtimeHoursText);

            // calculation formula
            return (hourlyRate * regularHours) + (hourlyRate * 1.8 * overtimeHours);
        }
    }

    private void displayResult(double weeklyPay) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        String result = formatter.format(weeklyPay);

        resultView.setText("Weekly pay: " + result);
    }

}
