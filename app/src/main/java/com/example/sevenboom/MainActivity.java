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
                    countTxt.setText("" + counter);
                } else {
                    Toast.makeText(MainActivity.this, "Max count of " + counter + " reached!", Toast.LENGTH_SHORT).show();
                }
                if (counter % 7 == 0){
                    Toast.makeText(MainActivity.this, "BOOM!! THE NUMBER " + counter + " DIVIDES IN SEVENS", Toast.LENGTH_SHORT).show();
                }

                int countercopy = counter;
                while(countercopy != 0) {
                    if (countercopy % 10 == 7){
                        Toast.makeText(MainActivity.this, "The number " + counter + " contains the digit 7.", Toast.LENGTH_SHORT).show();
                    }
                    countercopy /= 10;
                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > -20){
                    counter--;
                    countTxt.setText("" + counter);
                } else {
                    Toast.makeText(MainActivity.this, "Minimum count of " + counter + " reached!", Toast.LENGTH_SHORT).show();
                }
                if (counter % 7 == 0){
                    Toast.makeText(MainActivity.this, "BOOM!! THE NUMBER " + counter + " DIVIDES IN SEVENS", Toast.LENGTH_SHORT).show();
                }

                int countercopy = counter;
                while(countercopy != 0) {
                    if (countercopy % 10 == -7){
                        Toast.makeText(MainActivity.this, "The number " + counter + " contains the digit 7.", Toast.LENGTH_SHORT).show();
                    }
                    countercopy /= 10;
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                countTxt.setText("" + counter);
            }
        });


    }
}