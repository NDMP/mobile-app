package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private double currentResult = 0;
    private double lastNumber = 0;
    private String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Number buttons
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);

        // Operation buttons
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonExponent = findViewById(R.id.buttonExponent);
        Button buttonEqual = findViewById(R.id.buttonEqual);

        // Set onClick listeners for the number buttons
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                int number = Integer.parseInt(clickedButton.getText().toString());
                currentResult = currentResult * 10 + number; // Construct the number
                resultTextView.setText(String.valueOf(currentResult));
            }
        };

        // Set onClick listeners for operation buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastNumber = currentResult;
                currentOperation = "+";
                currentResult = 0;
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastNumber = currentResult;
                currentOperation = "-";
                currentResult = 0;
            }
        });

        buttonExponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastNumber = currentResult;
                currentOperation = "^";
                currentResult = 0;
            }
        });

        // Set onClick listener for equal button
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentOperation.equals("+")) {
                    currentResult = lastNumber + currentResult;
                } else if (currentOperation.equals("-")) {
                    currentResult = lastNumber - currentResult;
                } else if (currentOperation.equals("^")) {
                    currentResult = Math.pow(lastNumber, currentResult); // Exponentiation
                }
                resultTextView.setText(String.valueOf(currentResult));
            }
        });

        // Attach number click listeners
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);
        button0.setOnClickListener(numberClickListener);
    }
}
