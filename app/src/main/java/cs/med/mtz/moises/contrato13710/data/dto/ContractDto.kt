package cs.med.mtz.moises.contrato13710.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contract_table")
data class ContractDto(
    @ColumnInfo(name = "goal_id") val goalId: Int,
    val target: String,
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}