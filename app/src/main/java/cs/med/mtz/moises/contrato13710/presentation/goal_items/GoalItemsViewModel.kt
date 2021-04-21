package cs.med.mtz.moises.contrato13710.presentation.goal_items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.contrato13710.domain.ContractGoalRepository
import cs.med.mtz.moises.contrato13710.domain.entity.Goal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/** */
class GoalItemsViewModel(
    private val contractGoalRepository: ContractGoalRepository
) : ViewModel() {

    /** */
    fun getGoalsAsLiveData(): LiveData<List<Goal>> = flow {
        val goals: List<Goal> = contractGoalRepository.getGoals()
        emit(goals)
    }.asLiveData(Dispatchers.IO)

}