package cs.med.mtz.moises.contrato13710.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cs.med.mtz.moises.contrato13710.MainActivity
import cs.med.mtz.moises.contrato13710.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    /** */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivitySplash()
    }

    /**
     *
     */

    private fun startActivitySplash() {
        val intent = Intent(this, MainActivity::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            startActivity(intent)
        }
    }
}