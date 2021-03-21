package cs.med.mtz.moises.contrato13710.di.shared

import androidx.room.Room
import cs.med.mtz.moises.contrato13710.data.contract.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.contract.ContractDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/** */
val databaseModule: Module = module {

    single<ContractDatabase> {
        Room.databaseBuilder(
            androidContext(),
            ContractDatabase::class.java,
            "contract_database"
        ).build()
    }

    single<ContractDao> {
        get<ContractDatabase>().contractDao()
    }

}