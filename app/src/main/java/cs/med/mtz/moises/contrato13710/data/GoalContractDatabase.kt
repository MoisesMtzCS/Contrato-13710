package cs.med.mtz.moises.contrato13710.data

import androidx.room.Database
import androidx.room.RoomDatabase
import cs.med.mtz.moises.contrato13710.data.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.dao.GoalDao
import cs.med.mtz.moises.contrato13710.data.dto.ContractDto
import cs.med.mtz.moises.contrato13710.data.dto.GoalDto

@Database(
    entities = [
        GoalDto::class,
        ContractDto::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GoalContractDatabase : RoomDatabase() {

    /** */
    abstract fun goalDao(): GoalDao

    /** */
    abstract fun contractDao(): ContractDao

}