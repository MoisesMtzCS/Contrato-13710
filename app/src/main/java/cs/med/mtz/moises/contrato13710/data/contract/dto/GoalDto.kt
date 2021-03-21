package cs.med.mtz.moises.contrato13710.data.contract.dto

import androidx.room.Entity
import cs.med.mtz.moises.contrato13710.data.contract.dto.ContractDto

@Entity
data class GoalDto(
    val id: Int,
    val name:String,
    val contract: ContractDto
)