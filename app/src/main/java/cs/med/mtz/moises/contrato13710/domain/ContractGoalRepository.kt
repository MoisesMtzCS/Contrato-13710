package cs.med.mtz.moises.contrato13710.domain

import cs.med.mtz.moises.contrato13710.data.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.dao.GoalDao
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto
import cs.med.mtz.moises.contrato13710.data.dto.GoalDto
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.domain.entity.Goal
import java.util.*

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

    suspend fun getGoal(durationInDays: Int, createDate: Date): List<Goal> {
        val goalDto = goalDao.getGoals()
        val goals = goalDto.map { it ->
            val contractsDto = contractDao.getByGoalId(it.id!!)

            it.toGoal(
                contractsDto.map { it.toContract(durationInDays, createDate) })
        }
        return goals
    }

    suspend fun deleteGoal(id: Int) {
        val goal = goalDao.getById(id)
        goalDao.deleteGoal(goal)
    }

    suspend fun updateGoalName(id: Int, newName: String) {
        val goal = goalDao.getById(id)
        goal.name = newName
    }

    /** */
    suspend fun createContract(goalId: Int, target: String, durationInDays: Int) {
        val contractDto = ContractDto(1, target)
        contractDao.insert(contractDto)
    }


}