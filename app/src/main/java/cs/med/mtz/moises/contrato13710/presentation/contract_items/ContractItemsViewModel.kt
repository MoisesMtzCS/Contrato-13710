package cs.med.mtz.moises.contrato13710.presentation.contract_items

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.contrato13710.domain.ContractGoalRepository
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class ContractItemsViewModel(
    private val contractGoalRepository: ContractGoalRepository
) : ViewModel() {


    fun getContractsAsLiveData(id: Int): LiveData<List<Contract>> = flow {
        val contract = contractGoalRepository.getContracts(id)
        emit(contract)
    }.asLiveData(Dispatchers.IO)

    /** */


    fun deleteGoalAsLiveData(id: Int): LiveData<Unit> = flow {
        val goalDelete = contractGoalRepository.deleteGoal(id)
        emit(goalDelete)
    }.asLiveData(Dispatchers.IO)

    /** */

    fun updateGoalAsLiveData(id: Int, name: String): LiveData<Unit> = flow {
        val updateGoal = contractGoalRepository.updateGoalName(id, name)
        emit(updateGoal)
    }.asLiveData(Dispatchers.IO)


}