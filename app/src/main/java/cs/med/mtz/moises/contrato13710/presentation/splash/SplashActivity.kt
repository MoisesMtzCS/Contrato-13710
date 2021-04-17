package cs.med.mtz.moises.contrato13710.presentation.splash

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
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
        val isFirstTime: Boolean = getSharedPreferences(application.packageName, MODE_PRIVATE)
            .getBoolean("isFirstRun", false)

        val destination = if (isFirstTime) {
            Intent(this, MainActivity::class.java)
        } else Intent(this, IntoActivity::class.java)
        destination.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        getSharedPreferences(application.packageName, MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", true).apply()

        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            startActivity(destination)
        }
    }
}