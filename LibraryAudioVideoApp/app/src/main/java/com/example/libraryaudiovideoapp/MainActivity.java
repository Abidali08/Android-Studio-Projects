package com.example.libraryaudiovideoapp;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;


public class MainActivity extends AppCompatActivity {


    private SimpleExoPlayer player;
    private Button btnPlay, btnPause, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initButtons();
        initializePlayer();

    }

    private void initButtons() {
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) {
                    player.play();
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null && player.isPlaying()) {
                    player.pause();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) {
                    player.stop();
                    player.seekTo(0); // Reset to start
                }
            }
        });
    }

    private void initializePlayer() {
        player = new SimpleExoPlayer.Builder(this).build();
        String audioFilePath = "asset:///audio1.mp3"; // Place your audio file in the "assets" folder
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(audioFilePath));
        player.setMediaItem(mediaItem);
        player.prepare();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.release();
            player = null;
        }
    }

}