package com.example.iptv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.player_view)
        initPlayer()
    }

    private fun initPlayer() {
        player = ExoPlayer.Builder(this).build().apply {
            playerView.player = this

            val item1 = MediaItem.fromUri(getString(R.string.live_url))
            val item2 = MediaItem.fromUri(getString(R.string.live_url2))

            addMediaItem(item1)
            addMediaItem(item2)
            prepare()
            playWhenReady = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
        player = null
    }
}
