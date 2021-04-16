package cs.med.mtz.moises.contrato13710.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.presentation.into_activity.IntoActivity
import cs.med.mtz.moises.contrato13710.presentation.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


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
        //val isFirstTime: Boolean =
        // val destination = if (isFirstTime) IntoActivity::class.java else MainActivity::class.java
        //val intent = Intent(this, destination1234)
        val intent = Intent(this, IntoActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            startActivity(intent)
        }
    }
}