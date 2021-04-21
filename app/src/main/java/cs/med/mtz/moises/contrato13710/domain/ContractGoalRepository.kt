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
    suspend fun createGoalAndContract(name: String, target: String, durationInDays: Int):Long {
        val goalDto = GoalDto(name)
        val goalId: Long = goalDao.insert(goalDto)
        createContract(goalId.toInt(), target, durationInDays)
        return goalId

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
            it.toGoal(contractsDto.map { it.toContract() })
        }
    }

    /** */

    suspend fun deleteGoal(id: Int) {
        val goal = goalDao.getById(id)
        contractDao.deleteContractsByGoalId(id)
        goalDao.deleteGoal(goal)
    }

    /** */

    suspend fun updateGoalName(id: Int, newName: String) {
        val goal = goalDao.getById(id)
        goal.name = newName
        goalDao.insert(goal)
    }

    /** */
    suspend fun createContract(goalId: Int, target: String, durationInDays: Int) {
        val contractDto = ContractDto(goalId, target, durationInDays, Date())
        contractDao.insert(contractDto)
    }


    suspend fun getContracts(id: Int): List<Contract> {
        val contractDto = contractDao.getByGoalId(id)
        return contractDto.map {
            it.toContract()
        }
    }


}