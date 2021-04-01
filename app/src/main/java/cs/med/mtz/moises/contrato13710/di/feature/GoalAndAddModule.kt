package cs.med.mtz.moises.contrato13710.di.feature

import cs.med.mtz.moises.contrato13710.presentation.goal_holders.GoalItemsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val goalAndAddModule: Module = module {

    viewModel {
        GoalItemsViewModel(
            contractGoalRepository = get()
        )
    }

}