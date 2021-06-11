package com.example.viedostreamassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class ShowVideoActivity extends AppCompatActivity {
    private PlayerView playerView;
    SimpleExoPlayer player;
    private String videoUrl;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playPackPosition = 0;
    String uri1="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/snamdy.mp4?alt=media&token=8eb8ef3e-6b11-4c26-95ee-fc3818b8c880";
    private String uri2 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/shahdarts_1399780136808034304(320P).mp4?alt=media&token=6e7f64f7-0c46-4008-be66-a1ffc6070788";
    private String uri3 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/ShehabAgency_1390809832836509697(320P).mp4?alt=media&token=e13d66db-be03-4092-bdfa-de4622ab4f96";
    private String uri4 ="https://firebasestorage.googleapis.com/v0/b/piixel.appspot.com/o/2_5303156563169512675.mp4?alt=media&token=77e1d7aa-58ed-47a9-8607-0d2c6329efc0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);
        playerView = findViewById(R.id.viedo_view);
        String recUrl = getIntent().getStringExtra("uri");

        if (recUrl.equals(uri1)) {
            videoUrl = uri1;
        } else if (recUrl.equals(uri2)) {
            videoUrl = uri2;
        } else if (recUrl.equals(uri3)){
            videoUrl = uri3;
        }else if (recUrl.equals(uri4)){
            videoUrl = uri4;
        }



    }
    private void releaseVideo() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playPackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;

        }
    }

    private void initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(player);
        Uri uri = Uri.parse(videoUrl);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "exoplayer_codelab");
        Log.e("uriiiiiiiiiiiiiiiiiiiii",videoUrl);
        Log.e("cureent",currentWindow +"");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playPackPosition);
        player.prepare(mediaSource, false, false);

    }



    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (player != null) {
//            initVideo();
//        }
//    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }
}