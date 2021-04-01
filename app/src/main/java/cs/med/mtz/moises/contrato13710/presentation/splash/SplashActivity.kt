package cs.med.mtz.moises.contrato13710.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cs.med.mtz.moises.contrato13710.presentation.main.MainActivity
import cs.med.mtz.moises.contrato13710.R
import kotlinx.coroutines.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class SplashActivity : AppCompatActivity() {

    /* */
    private val splashViewModel: SplashViewModel by viewModel()

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
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            startActivity(intent)
        }
    }
}