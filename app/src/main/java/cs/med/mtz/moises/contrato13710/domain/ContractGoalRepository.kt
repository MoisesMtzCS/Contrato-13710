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
    suspend fun createGoalAndContract(name: String, target: String) {
        val goalDto = GoalDto(name)
        val goalId: Long = goalDao.insert(goalDto)
        createContract(goalId.toInt(), target)

    }


    suspend fun createGoal(name: String) {
        val goalDto = GoalDto(name)
        goalDao.insert(goalDto)
    }

    /** */

    suspend fun getGoals(): List<Goal> {
        val goalDto = goalDao.getGoals()
        return goalDto.map { it ->
            val contractsDto = contractDao.getByGoalId(it.id!!)

            it.toGoal(contractsDto.map { it.toContract(1, Date()) })
        }
    }

    /** */

    suspend fun deleteGoal(id: Int) {
        val goal = goalDao.getById(id)
        goalDao.deleteGoal(goal)
    }

    /** */

    suspend fun updateGoalName(id: Int, newName: String) {
        val goal = goalDao.getById(id)
        goal.name = newName
        goalDao.insert(goal)
    }

    /** */
    private suspend fun createContract(goalId: Int, target: String) {
        val contractDto = ContractDto(goalId, target)
        contractDao.insert(contractDto)
    }

    suspend fun getContracts(id: Int): List<Contract> {
        val contractDto = contractDao.getById(id)
        return contractDto.map {
            it.toContract(1, Date())
        }
    }


}