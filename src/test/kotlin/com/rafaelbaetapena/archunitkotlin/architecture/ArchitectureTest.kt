package com.rafaelbaetapena.archunitkotlin.architecture

import com.tngtech.archunit.core.importer.ImportOption.*
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(
    importOptions = [
        DoNotIncludeTests::class,
        DoNotIncludeJars::class,
        DoNotIncludeArchives::class],
    packages = ["com.rafaelbaetapena.archunitkotlin"],
    packagesOf = [ArchitectureTest::class]
)
class ArchitectureTest {

    // Config Package Rules
    @ArchTest
    val noClassesShouldResideInAPackageConfig: ArchRule =
        ArchRuleDefinition.noClasses().should().resideInAPackage(configPackageName)

    // DataProvider Package Rules
    @ArchTest
    val noClassesShouldResideInAPackageDataProvider: ArchRule =
        ArchRuleDefinition.noClasses().should().resideInAPackage(dataProviderPackageName)

    // Entrypoint Package Rules
    @ArchTest
    val noClassesShouldResideInAPackageEntrypoint: ArchRule =
        ArchRuleDefinition.noClasses().should().resideInAPackage(entrypointPackageName)

    companion object {
        const val configPackageName: String = "..config"
        const val dataProviderPackageName: String = "..dataprovider"
        const val entrypointPackageName: String = "..entrypoint"
    }



}