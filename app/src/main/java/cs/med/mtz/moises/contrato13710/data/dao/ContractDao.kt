package cs.med.mtz.moises.contrato13710.data.dao

import androidx.room.*
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto
import cs.med.mtz.moises.contrato13710.domain.entity.Contract

@Dao
interface ContractDao {

    @Query("SELECT * FROM contract_table")
    suspend fun getAll(): List<ContractDto>

    @Query("SELECT * FROM contract_table WHERE id = :id")
    fun getById(id: Int): List<ContractDto>

    @Query("SELECT * FROM contract_table WHERE goal_id = :goalId")
    suspend fun getByGoalId(goalId: Int): List<ContractDto>

    @Query("DELETE FROM contract_table WHERE goal_id = :goalId")
    suspend fun deleteContractsByGoalId(goalId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contract: ContractDto)

    @Insert
    suspend fun insertOne(contract: ContractDto):Long

    @Delete
    fun deleteContract(contract: ContractDto)

}
