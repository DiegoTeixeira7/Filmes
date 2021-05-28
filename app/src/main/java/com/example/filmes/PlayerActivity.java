package com.example.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    private List<Integer> trailers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getSupportActionBar().hide();

        trailers = new ArrayList<>();
        trailers.add(R.raw.velo4);
        trailers.add(R.raw.velo5);
        trailers.add(R.raw.velo6);
        trailers.add(R.raw.velo7);
        trailers.add(R.raw.velo8);
        trailers.add(R.raw.velo4hd);
        trailers.add(R.raw.velo5hd);
        trailers.add(R.raw.velo6hd);
        trailers.add(R.raw.velo7hd);
        trailers.add(R.raw.velo8hd);

        Intent it = getIntent();
        int atual = it.getIntExtra("atual", 0);
        boolean isHD = it.getBooleanExtra("isHD", false);
        int index = isHD ? atual + 5 : atual;

        VideoView videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + trailers.get(index));
        videoView.start();
    }
}