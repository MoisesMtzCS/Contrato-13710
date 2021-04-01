package cs.med.mtz.moises.contrato13710.presentation.contract_holders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.contrato13710.databinding.ActivityContractItemsBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.presentation.adapters.contract_adapter.ContractAdapter
import cs.med.mtz.moises.contrato13710.presentation.goal_holders.GoalItemsActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ContractItemsActivity : AppCompatActivity() {


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
    }

    private fun loadContractsList(id: Int) {
        contractItemsViewModel.getContractsAsLiveData(id)
            .observe(this) { fillRecyclerView(it) }
    }


    private fun setupOnDeleteGoalClickListener(id: Int) {
        binding.deleteButton.setOnClickListener {
            contractItemsViewModel.deleteLiveData(id).observe(this) {}
            startActivity(Intent(this, GoalItemsActivity::class.java))
            finish()
        }
    }

    private fun setupOnUpdateGoalNameClickListener(id: Int) {
        binding.updateButton.setOnClickListener {
            contractItemsViewModel.updateLiveData(id,newName).observe(this) {}
            startActivity(Intent(this, GoalItemsActivity::class.java))
            finish()
        }
    }

    private fun fillRecyclerView(contracts: List<Contract>) {
        val contractAdapter = ContractAdapter(contracts)
        binding.rvContract.adapter = contractAdapter
        binding.rvContract.layoutManager = LinearLayoutManager(this)
    }

    private fun titleGoal(){
        binding.nameGoal.text = nameGoal
    }
}