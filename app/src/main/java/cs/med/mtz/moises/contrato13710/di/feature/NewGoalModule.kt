package cs.med.mtz.moises.contrato13710.di.feature

import cs.med.mtz.moises.contrato13710.presentation.new_goal.NewGoalViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val newGoalModule: Module = module {

    viewModel {
        NewGoalViewModel(
            contractGoalRepository = get()
        )
    }

}