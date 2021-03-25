package cs.med.mtz.moises.contrato13710.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.domain.entity.Goal

@Entity(tableName = "goal_table")
data class GoalDto(
    var name: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    fun toGoal(contracts: List<Contract>): Goal = Goal(
        id = id!!,
        name = name,
        contracts = contracts
    )

}