package cs.med.mtz.moises.contrato13710.presentation.goal_items

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.contrato13710.databinding.ActivityGoalItemsBinding
import cs.med.mtz.moises.contrato13710.domain.entity.Goal
import cs.med.mtz.moises.contrato13710.presentation.adapters.goal_adapter.GoalAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class GoalItemsActivity : AppCompatActivity() {
    /**  */
    private val binding: ActivityGoalItemsBinding by lazy {
        ActivityGoalItemsBinding.inflate(layoutInflater)
    }

    /** */

    private val goalItemsViewModel: GoalItemsViewModel by viewModel()


    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        execute()
    }

    /** */
    private fun execute() {

        goalItemsViewModel.getGoalsAsLiveData().observe(this, goalsObserver)

    }


    /** */
    private fun observeViewModel() {
        goalItemsViewModel.goalsLiveData.observe(this) { goalsObserver }
    }

    private val goalsObserver: Observer<List<Goal>> = Observer {
        fillRecyclerView(it)
    }

    /** */
    private fun fillRecyclerView(goals: List<Goal>) {
        if (goals.isNotEmpty()) {
            val goalAdapter = GoalAdapter(goals)
            binding.rvContract.adapter = goalAdapter
            binding.rvContract.layoutManager = LinearLayoutManager(this)
        } else{
            binding.messageNoGoals.visibility = View.VISIBLE
            binding.ivSad.visibility = View.VISIBLE}

    }

}