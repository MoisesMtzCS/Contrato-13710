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


    fun createGoalFullLiveData(name: String, target: String, durationInDays: Int): LiveData<Long> =
        flow {
            val id = contractGoalRepository.createGoalAndContract(name, target, durationInDays)
            emit(id)
        }.asLiveData(Dispatchers.IO)


}