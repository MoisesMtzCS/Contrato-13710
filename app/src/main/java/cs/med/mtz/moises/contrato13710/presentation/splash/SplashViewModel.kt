package cs.med.mtz.moises.contrato13710.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.contrato13710.domain.ContractRepository
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

/** */
class SplashViewModel(
    private val contractRepository: ContractRepository
): ViewModel() {

    /** */
    fun createDummyContractAsLiveData(): LiveData<Unit> = flow {
        val target: String = "Despertar temprano"
        contractRepository.createContract(target)
        emit(Unit)
    }.asLiveData(Dispatchers.IO)

    /** */
    fun getAllContractsAsLiveData(): LiveData<List<Contract>> = flow {
        val contracts = contractRepository.getContracts()
        emit(contracts)
    }.asLiveData(Dispatchers.IO)


}