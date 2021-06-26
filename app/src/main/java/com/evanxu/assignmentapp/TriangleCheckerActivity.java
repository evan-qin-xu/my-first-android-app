package com.evanxu.assignmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class TriangleCheckerActivity extends AppCompatActivity {

    private EditText firstSide;
    private EditText secondSide;
    private EditText thirdSide;
    private TextView resultView;
    private Button checkButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // link the layout file and the java code
        setContentView(R.layout.activity_triangle_checker);

        findViews();
        setUpButtonClickListener();
    }

    // function to get view widgets from the layout file
    private void findViews() {
        firstSide = findViewById(R.id.edit_text_first_side);
        secondSide = findViewById(R.id.edit_text_second_side);
        thirdSide = findViewById(R.id.edit_text_third_side);
        resultView = findViewById(R.id.text_view_result);
        checkButton = findViewById(R.id.button_check);
    }

    // function to run when check button is clicked
    private void setUpButtonClickListener() {
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = checkTriangleType();
                displayResult(result);
            }
        });
    }

    // function to check triangle type
    private String checkTriangleType() {
        String firstSideText = firstSide.getText().toString();
        String secondSideText = secondSide.getText().toString();
        String thirdSideText = thirdSide.getText().toString();

        if (firstSideText.isEmpty() || secondSideText.isEmpty() || thirdSideText.isEmpty()) {
            Toast.makeText(this, "Please fill out values for all three sides", Toast.LENGTH_SHORT).show();
            return "";
        } else {
            double firstSide = Double.parseDouble(firstSideText);
            double secondSide = Double.parseDouble(secondSideText);
            double thirdSide = Double.parseDouble(thirdSideText);

            // use hash set to validate how many sides are the same because a hash set only contains unique value
            Set<Double> sidesSet = new HashSet<>();
            sidesSet.add(firstSide);
            sidesSet.add(secondSide);
            sidesSet.add(thirdSide);

            if (sidesSet.contains(0.00))
                return "Not a triangle";
            else if (sidesSet.size() == 1)
                return "Equilateral triangle";
            else if (sidesSet.size() == 2)
                return "Isosceles triangle";
            else
                return "Scalene triangle";
        }
    }

    private void displayResult(String str) {
        resultView.setText(str);
    }
}
