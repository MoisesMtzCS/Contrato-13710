package cs.med.mtz.moises.contrato13710.presentation.contract_items

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityContractItemsBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.presentation.adapters.contract_adapter.ContractAdapter
import cs.med.mtz.moises.contrato13710.presentation.goal_items.GoalItemsActivity
import cs.med.mtz.moises.contrato13710.presentation.main.MainActivity
import cs.med.mtz.moises.contrato13710.presentation.new_contract.NewContractActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class ContractItemsActivity : AppCompatActivity() {

    /**
     * variables for notification
     */
    private val channelId = "channel_id_01"
    private val notificationId = 101


    /** */
    val binding: ActivityContractItemsBinding by lazy {
        ActivityContractItemsBinding.inflate(layoutInflater)
    }

    private val contractItemsViewModel: ContractItemsViewModel by viewModel()

    /** */

    private val newName: String
        get() = binding.etName.text.toString()

    /* */
    private val contractId: Int by lazy { intent.extras!!.getInt("ID") }
    private val nameGoal: String? by lazy { intent.extras!!.getString("NAME") }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
        execute()
    }

    /** */
    private fun setupViews() {
        setupOnDeleteGoalClickListener(contractId)
        setupOnUpdateGoalNameClickListener(contractId)
    }

    /** */
    private fun execute() {
        loadContractsList(contractId)
        titleGoal()
        goCreateContractClickListener()
        createNotificatioChannel()
    }

    private fun loadContractsList(id: Int) {
        contractItemsViewModel.getContractsAsLiveData(id)
            .observe(this) { contracts ->
                fillRecyclerView(contracts)
                val sortedList: List<Contract> = contracts.sortedBy { it.creationDate }
                val lastContract: Contract = sortedList.last()
                makeVisibleAtTheEndOfTheContract(lastContract)
            }
    }

    /**
     *
     */
    private fun setupOnDeleteGoalClickListener(id: Int) {
        binding.deleteButton.setOnClickListener {
            alert(id)
        }
    }

    private fun alert(id: Int) {
        val builder = AlertDialog.Builder(this)
            .setTitle(getString(R.string.confirm_delete))
            .setPositiveButton("aceptar") { dialog, _ ->
                deleteGoalLiveData(id)
                dialog.dismiss() }
            .setNegativeButton("cancelar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun deleteGoalLiveData(id: Int) {
        contractItemsViewModel.deleteGoalAsLiveData(id).observe(this) {}
        startActivity(Intent(this, GoalItemsActivity::class.java))
        finish()
    }

    /**
     *
     */

    private fun setupOnUpdateGoalNameClickListener(id: Int) {
        makeVisibleUpdateClickListener()
        binding.updateButton.setOnClickListener {
            deleteGoalViewModel(id)
        }
    }

    private fun deleteGoalViewModel(id: Int) {
        contractItemsViewModel.updateGoalAsLiveData(id, newName).observe(this) {}
        startActivity(Intent(this, GoalItemsActivity::class.java))
        finish()
    }

    private fun fillRecyclerView(contracts: List<Contract>) {
        val contractAdapter = ContractAdapter(contracts)
        binding.rvContract.adapter = contractAdapter
        binding.rvContract.layoutManager = LinearLayoutManager(this)
    }

    private fun titleGoal() {
        binding.nameGoal.text = nameGoal
    }

    private fun makeVisibleUpdateClickListener() {
        binding.makeVisibleButton.setOnClickListener {
            binding.tilGoalName.visibility = View.VISIBLE
            binding.updateButton.visibility = View.VISIBLE
            binding.makeVisibleButton.visibility = View.GONE
        }
    }

    private fun goCreateContractClickListener() {
        binding.goNewContract.setOnClickListener {
            val id = intent.extras?.getInt("ID")
            val intent = Intent(this, NewContractActivity::class.java).apply {
                putExtra("ID", id)
            }
            startActivity(intent)
            finish()
        }
    }

    fun makeVisibleAtTheEndOfTheContract(contract: Contract) {
        val millsInADay = 86_400_000
        val contractCreationDate: Date = contract.creationDate
        val contractDurationInMills: Int = contract.durationInDays * millsInADay
        val now: Date = Date()
        val contractFinishedDateInUnix: Long = contractCreationDate.time + contractDurationInMills
        if (now.time > contractFinishedDateInUnix) {
            sendNotification()
            binding.goNewContract.visibility = View.VISIBLE
        }
    }


    /**
     * Notifications
     */
    private fun createNotificatioChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importace = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importace).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_contract)
            .setContentTitle("Example")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }


}