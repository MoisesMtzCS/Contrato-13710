package cs.med.mtz.moises.contrato13710.di.shared

import cs.med.mtz.moises.contrato13710.domain.ContractGoalRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/** */
val contractModule: Module = module {

    single {
        ContractGoalRepository(
            contractDao = get(),
        )
    }

}