package cs.med.mtz.moises.contrato13710.presentation.goal_holders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.contrato13710.databinding.ActivityGoalAndAddBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.domain.entity.Goal
import cs.med.mtz.moises.contrato13710.presentation.adapters.goal_adapter.GoalAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class GoalItemsActivity : AppCompatActivity() {
    /**  */
    private val binding: ActivityGoalAndAddBinding by lazy {
        ActivityGoalAndAddBinding.inflate(layoutInflater)
    }

    private val goalAndAddViewModel: GoalItemsViewModel by viewModel()

    val contracts = arrayListOf<Contract>()

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        execute()
    }

    /** */
    private fun execute() {
        goalAndAddViewModel.getGoalsAsLiveData().observe(this, goalsObserver)

    }



    /** */
    private fun observeViewModel() {
        goalAndAddViewModel.goalsLiveData.observe(this) { goalsObserver }
    }

    private val goalsObserver: Observer<List<Goal>> = Observer {
        fillRecyclerView(it)
    }

    /** */
    private fun fillRecyclerView(goals: List<Goal>) {
        val goalAdapter = GoalAdapter(goals)
        binding.rvContract.adapter = goalAdapter
        binding.rvContract.layoutManager = LinearLayoutManager(this)
    }

}