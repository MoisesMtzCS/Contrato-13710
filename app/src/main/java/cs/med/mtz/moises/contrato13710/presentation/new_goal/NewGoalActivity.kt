package cs.med.mtz.moises.contrato13710.presentation.new_goal

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityNewGoalBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.domain.entity.Goal
import cs.med.mtz.moises.contrato13710.presentation.goal_items.GoalItemsActivity
import cs.med.mtz.moises.contrato13710.system.broadcast.NotificationsBroadcastReceiver
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class NewGoalActivity : AppCompatActivity() {

    /** */

    private val nameGoal: String
        get() = binding.nameGoal.text.toString()

    private val target: String
        get() = binding.target.text.toString()

    /** */


    private val newGoalViewModel: NewGoalViewModel by viewModel()

    /** */

    private val binding: ActivityNewGoalBinding by lazy {
        ActivityNewGoalBinding.inflate(layoutInflater)
    }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        execute()
    }

    /** */

    private fun execute() {
        createGoalAndContractClickListener()
    }

    /** */

    private fun createGoalAndContractClickListener() {
        binding.save.setOnClickListener {
            if (nameGoal.isNotBlank() && target.isNotBlank()) {

                newGoalViewModel.createGoalFullLiveData(nameGoal, target, 1).observe(this) {
                    notificationLaunch(it)
                }
                val intent = Intent(this, GoalItemsActivity::class.java)
                startActivity(intent)
                finish()
            } else alertIncompleteData()
        }
    }

    /** */


    private fun alertIncompleteData() {
        val builder = AlertDialog.Builder(this)
            .setTitle(getString(R.string.incomplete_data))
            .setNegativeButton("aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    /** */


    private fun notificationLaunch(id: Long) {
        val millsInADay = 86_400_000
        val intent = Intent(this, NotificationsBroadcastReceiver::class.java).apply {
            putExtra("ID", id.toInt())
            putExtra("NAME", nameGoal)
        }
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val targetInMills = Date().time + millsInADay
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetInMills, pendingIntent)
    }


}

