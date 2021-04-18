package cs.med.mtz.moises.contrato13710.presentation.new_contract

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityNewContractBinding
import cs.med.mtz.moises.contrato13710.presentation.goal_items.GoalItemsActivity
import cs.med.mtz.moises.contrato13710.system.broadcast.NotificationsBroadcastReceiver
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class NewContractActivity : AppCompatActivity() {

    /** */
    private val newContractViewModel: NewContractViewModel by viewModel()

    /** */

    val target: String
        get() = binding.target.text.toString()

    /** */

    val binding: ActivityNewContractBinding by lazy {
        ActivityNewContractBinding.inflate(layoutInflater)
    }

    /** */
    private val contractId: Int by lazy { intent.extras!!.getInt("ID") }
    private val durationInDays: Int by lazy { intent.extras!!.getInt("DURATION") }
    private val nameGoal: String? by lazy { intent.extras!!.getString("NAME") }


    /** */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        createContractClickListener()
        e()
    }

    fun e() {
        binding.target.setText(intent.extras!!.getString("TARGET"))
    }


    private fun createContractClickListener() {
        binding.saveButton.setOnClickListener {
            if (target.isNotBlank()) {
                newContractViewModel.newContractLiveData(
                    contractId,
                    target,
                    durationOfContract(durationInDays)
                )
                    .observe(this) {}
                sendNotificationAfterTheTime(
                    durationOfContract(durationInDays)
                )
                startActivity(Intent(this, GoalItemsActivity::class.java))
                finish()
            } else alertIncompleteData()
        }
    }

    private fun alertIncompleteData() {
        val builder = AlertDialog.Builder(this)
            .setTitle(getString(R.string.incomplete_data))
            .setNegativeButton("aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    private fun durationOfContract(currentDuration: Int): Int {
        return when (currentDuration) {
            1 -> currentDuration + 2
            3 -> currentDuration + 4
            7 -> currentDuration + 3
            else -> currentDuration
        }
    }

    private fun sendNotificationAfterTheTime(days: Int) {
        val millsInADay = 86_400_000
        val intent = Intent(this, NotificationsBroadcastReceiver::class.java).apply {
            putExtra("ID", contractId)
            putExtra("NAME",nameGoal)
        }
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val targetInMills = Date().time + 5_000// (millsInADay * days)
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetInMills, pendingIntent)
    }
}