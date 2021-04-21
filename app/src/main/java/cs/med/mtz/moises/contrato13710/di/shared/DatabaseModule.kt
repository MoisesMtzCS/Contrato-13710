package cs.med.mtz.moises.contrato13710.di.shared

import cs.med.mtz.moises.contrato13710.data.GoalContractDatabase
import cs.med.mtz.moises.contrato13710.data.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.dao.GoalDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/** */
val databaseModule: Module = module {

    single<GoalContractDatabase> {
        GoalContractDatabase.getDatabase(
            androidContext(),
            CoroutineScope(SupervisorJob())
        )
    }

    single<GoalDao> {
        get<GoalContractDatabase>().goalDao()
    }

    single<ContractDao> {
        get<GoalContractDatabase>().contractDao()
    }

}