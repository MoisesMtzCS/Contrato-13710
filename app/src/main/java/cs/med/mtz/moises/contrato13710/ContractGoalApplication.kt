package cs.med.mtz.moises.contrato13710

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import cs.med.mtz.moises.contrato13710.data.GoalContractDatabase
import cs.med.mtz.moises.contrato13710.di.getApplicationModules
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/** */
class ContractGoalApplication : Application() {


    /**
     * variable for notification
     */
    private val channelId = "channel_id_01"

    /** */
    override fun onCreate() {
        super.onCreate()
        initKoin()
        CoroutineScope(Dispatchers.IO).launch {
            get<GoalContractDatabase>().contractDao().initDatabase()
        }
    }

    /** */
    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(getApplicationModules())
        }
    }
    /**
     * Notifications
     */
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}