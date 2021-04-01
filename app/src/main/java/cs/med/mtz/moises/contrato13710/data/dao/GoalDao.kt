package cs.med.mtz.moises.contrato13710.data.dao

import androidx.room.*
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto
import cs.med.mtz.moises.contrato13710.data.dto.GoalDto

@Dao
interface GoalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goalDto: GoalDto): Long


    @Query("SELECT * FROM goal_table")
    suspend fun getGoals(): List<GoalDto>


    @Query("SELECT * FROM goal_table WHERE id = :id")
    suspend fun getById(id: Int): GoalDto



    @Delete
    suspend fun deleteGoal(goalDto: GoalDto)


}