package com.rafaelbaetapena.archunitkotlin.architecture

import com.rafaelbaetapena.archunitkotlin.architecture.config.ConfigRules
import com.rafaelbaetapena.archunitkotlin.architecture.core.CoreRules
import com.rafaelbaetapena.archunitkotlin.architecture.core.PortRules
import com.rafaelbaetapena.archunitkotlin.architecture.dataprovider.DataProviderRules
import com.rafaelbaetapena.archunitkotlin.architecture.entrypoint.EntrypointRules
import com.tngtech.archunit.core.importer.ImportOption.*
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.junit.ArchTests

@AnalyzeClasses(
    importOptions = [
        DoNotIncludeTests::class,
        DoNotIncludeJars::class,
        DoNotIncludeArchives::class],
    packages = ["com.rafaelbaetapena.archunitkotlin"]
)
class ArchitectureTest {

    // Config Package Rules
    @ArchTest
    val configRules: ArchTests = ArchTests.`in`(ConfigRules::class.java)

    // Core Package Rules
    @ArchTest
    val coreRules: ArchTests = ArchTests.`in`(CoreRules::class.java)

    // Core.Port Package Rules
    @ArchTest
    val portRules: ArchTests = ArchTests.`in`(PortRules::class.java)

    // DataProvider Package Rules
    @ArchTest
    val dataProviderRules: ArchTests = ArchTests.`in`(DataProviderRules::class.java)

    // Entrypoint Package Rules
    @ArchTest
    val entrypointRules: ArchTests = ArchTests.`in`(EntrypointRules::class.java)
}