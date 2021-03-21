package cs.med.mtz.moises.contrato13710.data.dao

import androidx.room.*
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto

@Dao
interface ContractDao {

    @Query("SELECT * FROM contract_table")
    suspend fun getAll(): List<ContractDto>

    @Query("SELECT * FROM contract_table WHERE id = :id")
    fun getById(id: Int): ContractDto

    @Query("SELECT * FROM contract_table WHERE goal_id = :goalId")
    suspend fun getByGoalId(goalId: Int): List<ContractDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contract: ContractDto)

    @Delete
    fun deleteContract(contract: ContractDto)

}
