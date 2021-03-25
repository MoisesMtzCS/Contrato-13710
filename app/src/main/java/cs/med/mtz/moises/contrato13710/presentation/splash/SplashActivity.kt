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

    /** */
//    private fun execute() {
////        splashViewModel.createDummyContractAsLiveData().observe(this) {
////            Log.e("TEST", "YEAAAAH")
////        }
//        val now = Date()
//        val nextAlarm = Calendar.getInstance().apply {
//            time = now
//            add(Calendar.DATE, 1)
//            add(Calendar.HOUR, 3)
//
//        }
//
//        GregorianCalendar(2021, 3, 18)
//
//
//        splashViewModel.getAllContractsAsLiveData().observe(this) {
//            Log.e("TEST", it.toString())
//        }
//    }


    /**
     *
     */

    private fun startActivitySplash() {
        val intent = Intent(this, MainActivity::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            startActivity(intent)
            finish()
        }
    }
}