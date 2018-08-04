package com.example.rathana.localnotificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rathana.localnotificationdemo.util.NotificationHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnSimpleNotification,btnBigText,btnBigPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSimpleNotification=findViewById(R.id.simpleNotification);
        btnBigText=findViewById(R.id.BigTextStyleNotification);
        btnBigPicture=findViewById(R.id.BigPictureStyleNotification);
        btnSimpleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NotificationHelper(MainActivity.this).
                        createSimpleNotification("Hello","this is my first notification");

            }
        });

        btnBigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NotificationHelper(MainActivity.this).createBigTextStyleNotification(
                        "Hello",
                        "this is my first notification");
            }

        });
        btnBigPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NotificationHelper(MainActivity.this).createBigPictureStyleNotification(
                        "Hello",
                        "this is my first notification");
            }

        });
    }
}
