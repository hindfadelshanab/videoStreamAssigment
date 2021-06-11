package com.example.viedostreamassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4;
    private String u1 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/snamdy.mp4?alt=media&token=8eb8ef3e-6b11-4c26-95ee-fc3818b8c880";
    private String u2 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/shahdarts_1399780136808034304(320P).mp4?alt=media&token=6e7f64f7-0c46-4008-be66-a1ffc6070788";
    private String u3 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/ShehabAgency_1390809832836509697(320P).mp4?alt=media&token=e13d66db-be03-4092-bdfa-de4622ab4f96";
    private String u4 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/2_5303156563169512675.mp4?alt=media&token=77e1d7aa-58ed-47a9-8607-0d2c6329efc0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button_v1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button_v2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.button_v3);
        button3.setOnClickListener(this);

        button4 = findViewById(R.id.button_v4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_v1:
                GoToShowVideo(u1);
                break;
            case R.id.button_v2:
                //Stop MediaPlayer
                GoToShowVideo(u2);
                break;
            case R.id.button_v3:
                GoToShowVideo(u3);
                break;
            case R.id.button_v4:
                GoToShowVideo(u4);

                break;

        }
    }

    private void GoToShowVideo(String uri) {
        Intent intent = new Intent(this, ShowVideoActivity.class);
        intent.putExtra("uri", uri);
        startActivity(intent);
    }
}