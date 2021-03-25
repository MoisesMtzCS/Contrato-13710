package cs.med.mtz.moises.contrato13710.presentation.new_goal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.contrato13710.domain.ContractGoalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class NewGoalViewModel(
    private val contractGoalRepository: ContractGoalRepository
) : ViewModel() {


//    /** */
//    fun createDummyContractAsLiveData(): LiveData<Unit> = flow {
//        val target: String = ""
//        contractGoalRepository.createContract(1, target, 1)
//        emit(Unit)
//    }.asLiveData(Dispatchers.IO)


    fun newGoal(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            contractGoalRepository.createGoal(name)
        }
    }


}