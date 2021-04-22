package cs.med.mtz.moises.contrato13710.presentation.tutorial

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import cs.med.mtz.moises.contrato13710.R

class TutorialActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    /** */

    private val apiKey = "AIzaSyArmGoaP0OUUudkNR5VeA1s3v6dhoT6LLM"

    /** */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        val youtube = findViewById<YouTubePlayerView>(R.id.youtube)
        youtube.initialize(apiKey, this)

    }

    /** */

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        if (!wasRestored) {
            player?.cueVideo("7OiCb_5IEa4")
            player?.play()
        }
    }

    /** */

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

}