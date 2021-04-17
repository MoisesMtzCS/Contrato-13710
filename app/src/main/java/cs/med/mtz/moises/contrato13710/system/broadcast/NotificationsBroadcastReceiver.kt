package cs.med.mtz.moises.contrato13710.system.broadcast

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.presentation.contract_items.ContractItemsActivity
import kotlin.random.Random

/** */
class NotificationsBroadcastReceiver : BroadcastReceiver() {

    /* */
    private val channelId = "channel_id_01"

    /** */
    override fun onReceive(context: Context?, intent: Intent) {
        val id = intent.getIntExtra("ID", -1)
        val name = intent.getStringExtra("NAME")
        if (id == -1) return
        val notification = createNotification(context ?: return, id,name!!)
        NotificationManagerCompat.from(context).notify(Random.nextInt(0, 200), notification)
    }

    private fun createNotification(context: Context, id: Int, name:String): Notification {
        val intent = Intent(context, ContractItemsActivity::class.java).apply {
            putExtra("ID", id)
            putExtra("NAME",name)
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