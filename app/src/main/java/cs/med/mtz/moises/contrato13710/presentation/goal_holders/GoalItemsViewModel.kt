package cs.med.mtz.moises.contrato13710.presentation.goal_holders

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
import kotlinx.coroutines.runBlocking

class GoalItemsViewModel(
    private val contractGoalRepository: ContractGoalRepository

) : ViewModel() {

    private val goalsMutableLiveData: MutableLiveData<List<Goal>> = MutableLiveData()
    val goalsLiveData: LiveData<List<Goal>> get() = goalsMutableLiveData

    /** */
    fun executeLoadGoals() = CoroutineScope(Dispatchers.IO).launch {
        val goals = contractGoalRepository.getGoals()
        goalsMutableLiveData.postValue(goals)
    }

    /** */
    fun getGoalsAsLiveData(): LiveData<List<Goal>> = flow {
        val goals = contractGoalRepository.getGoals()
        emit(goals)
    }.asLiveData(Dispatchers.IO)

    /** */


}