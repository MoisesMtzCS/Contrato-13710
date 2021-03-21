package cs.med.mtz.moises.contrato13710.domain.entity

data class Goal(
  val id: Int,
  val name:String,
  val contracts: List<Contract>
)