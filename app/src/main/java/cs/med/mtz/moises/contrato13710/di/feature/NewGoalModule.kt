package cs.med.mtz.moises.contrato13710.di.feature

import androidx.lifecycle.ViewModel
import cs.med.mtz.moises.contrato13710.presentation.new_goal.NewGoalViewModel
import cs.med.mtz.moises.contrato13710.presentation.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val NewGoalModule: Module = module {
    viewModel {
        SplashViewModel(
            contractRepository = get(),
        )
    }
}