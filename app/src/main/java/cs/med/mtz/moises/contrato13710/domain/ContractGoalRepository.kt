package cs.med.mtz.moises.contrato13710.domain

import cs.med.mtz.moises.contrato13710.data.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.dao.GoalDao
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto
import cs.med.mtz.moises.contrato13710.data.dto.GoalDto
import cs.med.mtz.moises.contrato13710.domain.entity.Goal

/** */
class ContractGoalRepository(
    private val goalDao: GoalDao,
    private val contractDao: ContractDao,
) {

    /** */
    suspend fun createGoal(name: String) {
        val goalDto = GoalDto(name)
        goalDao.insert(goalDto)
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