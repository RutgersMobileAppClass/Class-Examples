package com.example.instructor.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /*
    Ran into an error targeting higher versions of Android
    Will go back and fix this and resend it
     */
    // Number between 0  - 65535, lower 16 bits
    private static final int REQ_CODE_TAKE_PICTURE = 30210;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(picIntent,REQ_CODE_TAKE_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == REQ_CODE_TAKE_PICTURE && resultCode == RESULT_OK){
            Bitmap bmp = (Bitmap) intent.getExtras().get("data");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap(bmp);
        }
    }
}
