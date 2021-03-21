package cs.med.mtz.moises.contrato13710

import android.app.Application
import cs.med.mtz.moises.contrato13710.di.getApplicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/** */
class ContractGoalApplication : Application() {

    /** */
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    /** */
    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(getApplicationModules())
        }
    }

}