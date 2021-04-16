package cs.med.mtz.moises.contrato13710.system.broadcast

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.presentation.contract_items.ContractItemsActivity
import cs.med.mtz.moises.contrato13710.presentation.main.MainActivity

/** */
class NotificationsBroadcastReceiver : BroadcastReceiver() {

    /* */
    private val channelId = "channel_id_01"


    /** */
    override fun onReceive(context: Context?, intent: Intent?) {
        val notification = createNotification(context ?: return)
        NotificationManagerCompat.from(context).notify(200, notification)
    }

    private fun createNotification(context: Context): Notification {
        val intent = Intent(context, ContractItemsActivity::class.java).apply {
        }
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_contract)
            .setContentTitle("Su contrato ha finalizado")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        return builder.build()
    }

}