package cs.med.mtz.moises.contrato13710.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import cs.med.mtz.moises.contrato13710.data.dto.GoalDto

@Dao
interface GoalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goalDto: GoalDto)

    // ...

}