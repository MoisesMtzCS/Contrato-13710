package cs.med.mtz.moises.contrato13710.data.dao

import androidx.room.*
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto

@Dao
interface ContractDao {

    @Query("SELECT COUNT(id) FROM contract_table LIMIT 0")
    suspend fun initDatabase(): Int

    @Query("SELECT * FROM contract_table WHERE id = :id")
    fun getById(id: Int): List<ContractDto>

    @Query("SELECT * FROM contract_table WHERE goal_id = :goalId")
    suspend fun getByGoalId(goalId: Int): List<ContractDto>

    @Query("DELETE FROM contract_table WHERE goal_id = :goalId")
    suspend fun deleteContractsByGoalId(goalId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contract: ContractDto):Long

    @Insert
    suspend fun insertOne(contract: ContractDto):Long

    @Delete
    fun deleteContract(contract: ContractDto)

}
