package cs.med.mtz.moises.contrato13710.domain

import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.data.contract.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.contract.dto.ContractDto
import cs.med.mtz.moises.contrato13710.domain.entity.Goal

/** */
class ContractGoalRepository(
    private val contractDao: ContractDao
) {

    /** */
    suspend fun createGoal(name: String) {
        TODO()
    }

    suspend fun getGoals(): List<Goal> {
        TODO()
    }

    suspend fun deleteGoal(id: Int) {
        TODO()
    }

    suspend fun updateGoalName(id: Int, newName: String) {
        TODO()
    }

    /** */
    suspend fun createContract(goalId: Int, target: String, durationInDays: Int) {
        val contractDto = ContractDto(1, target)
        contractDao.insert(contractDto)
    }


}