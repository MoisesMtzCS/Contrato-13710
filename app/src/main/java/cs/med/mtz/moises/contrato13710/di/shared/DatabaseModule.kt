package cs.med.mtz.moises.contrato13710.di.shared

import androidx.room.Room
import cs.med.mtz.moises.contrato13710.data.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.GoalContractDatabase
import cs.med.mtz.moises.contrato13710.data.dao.GoalDao
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/** */
val databaseModule: Module = module {

    single<GoalContractDatabase> {
        Room.databaseBuilder(
            androidContext(),
            GoalContractDatabase::class.java,
            "contract_database"
        ).build()
    }

    single<GoalDao> {
        get<GoalContractDatabase>().goalDao()
    }

    single<ContractDao> {
        get<GoalContractDatabase>().contractDao()
    }

}