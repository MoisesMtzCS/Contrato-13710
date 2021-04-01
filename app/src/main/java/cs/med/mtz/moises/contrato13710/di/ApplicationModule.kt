package cs.med.mtz.moises.contrato13710.di

import cs.med.mtz.moises.contrato13710.di.feature.contractIntemsModule
import cs.med.mtz.moises.contrato13710.di.feature.goalAndAddModule
import cs.med.mtz.moises.contrato13710.di.feature.newGoalModule
import cs.med.mtz.moises.contrato13710.di.feature.splashModule
import cs.med.mtz.moises.contrato13710.di.shared.contractModule
import cs.med.mtz.moises.contrato13710.di.shared.databaseModule
import org.koin.core.module.Module

/** */
fun getApplicationModules(): List<Module> {
    val featureModules: List<Module> = listOf(splashModule, newGoalModule, goalAndAddModule,contractIntemsModule)
    val sharedModules: List<Module> = listOf(databaseModule, contractModule)
    return featureModules + sharedModules
}