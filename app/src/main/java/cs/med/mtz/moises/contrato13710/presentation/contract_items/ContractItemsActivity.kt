package cs.med.mtz.moises.contrato13710.presentation.contract_items

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityContractItemsBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.presentation.adapters.contract_adapter.ContractAdapter
import cs.med.mtz.moises.contrato13710.presentation.goal_items.GoalItemsActivity
import cs.med.mtz.moises.contrato13710.presentation.new_contract.NewContractActivity
import cs.med.mtz.moises.contrato13710.system.broadcast.NotificationsBroadcastReceiver
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception
import java.util.*

class ContractItemsActivity : AppCompatActivity() {



    /** */
    val binding: ActivityContractItemsBinding by lazy {
        ActivityContractItemsBinding.inflate(layoutInflater)
    }

    /**
     * View model
     */

    private val contractItemsViewModel: ContractItemsViewModel by viewModel()

    /** */

    private val newName: String
        get() = binding.etName.text.toString()

    /** */
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
    }

    private fun loadContractsList(id: Int) {
        contractItemsViewModel.getContractsAsLiveData(id)
            .observe(this) { contracts ->
                fillRecyclerView(contracts)
                val sortedList: List<Contract> = contracts.sortedBy { it.creationDate }
                val lastContract: Contract = sortedList.last()
                goCreateContractClickListener(lastContract)
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
                dialog.dismiss()
            }
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
            contractItemsViewModel.updateGoalAsLiveData(id, newName).observe(this) {}
            startActivity(Intent(this, GoalItemsActivity::class.java))
            finish()

        }
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

    private fun goCreateContractClickListener(contract: Contract) {
        binding.goNewContract.setOnClickListener {
            val id = intent.extras?.getInt("ID")
            val intent = Intent(this, NewContractActivity::class.java).apply {
                putExtra("ID", contractId)
                putExtra("DURATION", contract.durationInDays)
                putExtra("TARGET", contract.target)
                putExtra("NAME", nameGoal)
            }
            startActivity(intent)
            finish()
        }
    }

    private fun makeVisibleAtTheEndOfTheContract(contract: Contract) {
        val millsInADay = 86_400_000
        val contractCreationDate: Date = contract.creationDate
        val contractDurationInMills: Int = contract.durationInDays * millsInADay
        val now: Date = Date()
        val contractFinishedDateInUnix: Long = contractCreationDate.time + contractDurationInMills
        if (now.time > contractFinishedDateInUnix) {
            binding.goNewContract.visibility = View.VISIBLE
        }
    }





}