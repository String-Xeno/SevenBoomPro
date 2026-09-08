package com.example.sevenboom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countTxt = findViewById(R.id.counter);
        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button resetButton = findViewById(R.id.resetButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter < 100){
                    counter++;
                    updateCounter(countTxt);
                    dividesInSevensToast();
                    hasSevenDigitToast();
                } else {
                    countLimitToast();
                }



            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > -20){
                    counter--;
                    updateCounter(countTxt);
                    dividesInSevensToast();
                    hasSevenDigitToast();
                } else {
                    countLimitToast();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                updateCounter(countTxt);
            }
        });


    }
    public void updateCounter(TextView countToUpdate){
        countToUpdate.setText(counter);
    }


    public void dividesInSevensToast(){
        if (counter % 7 == 0)
            Toast.makeText(MainActivity.this, "BOOM!! THE NUMBER " + counter + " DIVIDES IN SEVENS", Toast.LENGTH_SHORT).show();
    }

    public void hasSevenDigitToast(){
        int countercopy = counter;
        while(countercopy != 0) {
            if (countercopy % 10 == 7 || countercopy % 10 == -7){
                Toast.makeText(MainActivity.this, "The number " + counter + " contains the digit 7.", Toast.LENGTH_SHORT).show();
            }
            countercopy /= 10;
        }
    }

    public void countLimitToast(){
        Toast.makeText(MainActivity.this, "count limit of " + counter + " reached!", Toast.LENGTH_SHORT).show();
    }
}