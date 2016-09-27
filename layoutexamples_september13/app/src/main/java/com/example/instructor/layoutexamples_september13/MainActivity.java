package com.example.instructor.layoutexamples_september13;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    private ImageView turtlePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turtlePicture = (ImageView)findViewById(R.id.turtlePicture);


    }

    public void buttonClick(View buttonClicked) {
        int clicked = buttonClicked.getId();
        if(clicked == R.id.leoButton ){
            turtlePicture.setImageResource(R.drawable.leotmnt);

            MediaPlayer mp = MediaPlayer.create(this,R.raw.buzz1);
            mp.start();

        }
        else if(clicked == R.id.mikeButton){
            turtlePicture.setImageResource(R.drawable.michaelangelotmnt);
            MediaPlayer mp = MediaPlayer.create(this,R.raw.buzz2);
            mp.start();
        }



    }
}
