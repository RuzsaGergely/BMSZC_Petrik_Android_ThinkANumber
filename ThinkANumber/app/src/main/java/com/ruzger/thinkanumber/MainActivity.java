package com.ruzger.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView _currentNumber;
    private Button _buttonPlus;
    private Button _buttonMinus;
    private Button _buttonGuess;
    private ConstraintLayout _layout;
    private int generatedNumber = -1;
    private int currentNumber = 0;
    Random rnd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInit();

        _buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentNumber > 0){
                    currentNumber--;
                    _currentNumber.setText(Integer.toString(currentNumber));
                }
            }
        });

        _buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentNumber < 10) {
                    currentNumber++;
                    _currentNumber.setText(Integer.toString(currentNumber));
                }
            }
        });

        _buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentNumber == generatedNumber) {
                    _currentNumber.setTextColor(Color.GREEN);
                } else {
                    _currentNumber.setTextColor(Color.RED);

                }
            }
        });
    }

    void onInit() {
        _currentNumber = findViewById(R.id.currentNumber);
        _buttonPlus = findViewById(R.id.buttonPlus);
        _buttonMinus = findViewById(R.id.buttonMinus);
        _buttonGuess = findViewById(R.id.buttonGuess);
        _layout = findViewById(R.id.constrLayout);

        _currentNumber.setText(Integer.toString(currentNumber));
        generatedNumber = rnd.nextInt(11);

    }
}