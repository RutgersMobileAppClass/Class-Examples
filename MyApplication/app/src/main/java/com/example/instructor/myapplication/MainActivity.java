package com.example.instructor.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button rightButton;     // Reference to the right button
    private Button leftButton;      // Reference to the left button
    private TextView pointsText;    // Reference to the points text at bottom

    private int leftButtonInt = 0;
    private int rightButtonInt = 0;
    private int pointsInt = 0;      // Keep track of the score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Use findViewById to grab references to the GUI objects
        // You need to downcast to the right object becaues findViewById returns View objects
        pointsText = (TextView) findViewById(R.id.pointsText);
        rightButton = (Button) findViewById(R.id.rightButton);
        leftButton = (Button) findViewById(R.id.leftButton);

        numberSetter();

    }

    // Our function to update the numbers and update the text
    public void numberSetter(){

        Random randy = new Random();


        // Note: it is smarter to use a do-while loop instead of a while loop
        // Why?
        leftButtonInt = rightButtonInt; // ensure the loop runs once

        while(leftButtonInt == rightButtonInt){
            leftButtonInt = randy.nextInt(10);
            rightButtonInt = randy.nextInt(10);
        }

        rightButton.setText(rightButtonInt + "");
        leftButton.setText(leftButtonInt + "");



    }

    public void leftButtonClick(View view) {
        // Executed code when button pressed goes here

        if(leftButtonInt > rightButtonInt){
            Toast.makeText(this,"You're correct!", Toast.LENGTH_SHORT).show();
            pointsInt++;
        }
        else{
            Toast.makeText(this,"You're wrong!", Toast.LENGTH_SHORT).show();
            pointsInt--;
        }

        pointsText.setText("Points:" + pointsInt);

        numberSetter();


    }

    public void rightButtonClick(View view) {
        // Executed code when button pressed goes here

        if(leftButtonInt < rightButtonInt){
            Toast.makeText(this,"You're correct!", Toast.LENGTH_SHORT).show();
            pointsInt++;
        }
        else{
            Toast.makeText(this,"You're wrong!", Toast.LENGTH_SHORT).show();
            pointsInt--;
        }

        pointsText.setText("Points:" + pointsInt);

        numberSetter();
    }
}
