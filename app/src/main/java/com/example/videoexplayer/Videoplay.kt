package com.example.videoexplayer

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class Videoplay : AppCompatActivity() {

   // private lateinit var videoView: PlayerView
    private lateinit var player: SimpleExoPlayer
  //  private lateinit var playerView: PlayerView
  private lateinit var playerView: PlayerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplay)

        playerView = findViewById(R.id.vidView)

        // Create a SimpleExoPlayer using the Builder
        player = SimpleExoPlayer.Builder(this).build()

        // Attach the player to the PlayerView
        playerView.player = player

        // Create a MediaItem using Uri
        val videoUri = Uri.parse("https://example.com/your-video.mp4")
        val mediaItem = MediaItem.fromUri(videoUri)

        // Set the MediaItem to the player
        player.setMediaItem(mediaItem)

        // Prepare the player
        player.prepare()

        // Start playing the video
        player.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the player when the activity is destroyed
        player.release()
    }
    }
