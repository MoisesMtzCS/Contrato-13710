package cs.med.mtz.moises.contrato13710.domain.entity

import java.util.*

/** */
data class Contract(
    val id: Int,
    val target: String,
    val durationInDays:Int,
    val createDate: Date
)