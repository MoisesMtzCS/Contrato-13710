package cs.med.mtz.moises.contrato13710.presentation.new_contract

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.contrato13710.domain.ContractGoalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class NewContractViewModel(
    private val contractGoalRepository: ContractGoalRepository
) : ViewModel() {
    /** */

    fun newContractLiveData(id: Int, target: String, durationInDays: Int): LiveData<Unit> = flow {
        contractGoalRepository.createContract(id, target, durationInDays)
        emit(Unit)
    }.asLiveData(Dispatchers.IO)
}