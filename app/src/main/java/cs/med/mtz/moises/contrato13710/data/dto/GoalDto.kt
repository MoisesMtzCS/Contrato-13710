package cs.med.mtz.moises.contrato13710.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goal_table")
data class GoalDto(
    val name: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}