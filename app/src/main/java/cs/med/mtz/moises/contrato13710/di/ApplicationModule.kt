package cs.med.mtz.moises.contrato13710.di

import cs.med.mtz.moises.contrato13710.di.feature.*
import cs.med.mtz.moises.contrato13710.di.shared.contractModule
import cs.med.mtz.moises.contrato13710.di.shared.databaseModule
import org.koin.core.module.Module

/** */
fun getApplicationModules(): List<Module> {
    val featureModules: List<Module> = listOf(
        newGoalModule,
        goalAndAddModule,
        contractIntemsModule,
        newContractModule
    )
    val sharedModules: List<Module> = listOf(databaseModule, contractModule)
    return featureModules + sharedModules
}