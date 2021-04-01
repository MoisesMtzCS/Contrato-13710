package cs.med.mtz.moises.contrato13710.di.feature

import cs.med.mtz.moises.contrato13710.presentation.contract_holders.ContractItemsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val contractIntemsModule: Module = module {

    viewModel {
        ContractItemsViewModel(
            contractGoalRepository = get()
        )
    }

}