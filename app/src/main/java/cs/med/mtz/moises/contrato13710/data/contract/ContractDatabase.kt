package cs.med.mtz.moises.contrato13710.data.contract

import androidx.room.Database
import androidx.room.RoomDatabase
import cs.med.mtz.moises.contrato13710.data.contract.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.contract.dto.ContractDto

@Database(
    entities = [ContractDto::class],
    version = 1,
    exportSchema = false
)
abstract class ContractDatabase :RoomDatabase() {

    /** */
    abstract fun contractDao(): ContractDao

}