package cs.med.mtz.moises.contrato13710.presentation.new_goal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.contrato13710.domain.ContractGoalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class NewGoalViewModel(
    private val contractGoalRepository: ContractGoalRepository
) : ViewModel() {


    /** */


    fun createGoalFullLiveData(name: String, target: String, durationInDays: Int): LiveData<Unit> =
        flow {
            contractGoalRepository.createGoalAndContract(name, target, durationInDays)
            emit(Unit)
        }.asLiveData(Dispatchers.IO)


    fun createDummyContractAsLiveData(target: String): LiveData<Unit> = flow {
        //contractGoalRepository.createContract(target)
        emit(Unit)
    }.asLiveData(Dispatchers.IO)


    fun newGoalLiveData(name: String): LiveData<Unit> = flow {
        contractGoalRepository.createGoal(name)
        emit(Unit)
    }.asLiveData(Dispatchers.IO)


}