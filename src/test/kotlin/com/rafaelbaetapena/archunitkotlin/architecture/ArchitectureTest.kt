package com.rafaelbaetapena.archunitkotlin.architecture

import com.tngtech.archunit.core.importer.ImportOption.*
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*

@AnalyzeClasses(
    importOptions = [
        DoNotIncludeTests::class,
        DoNotIncludeJars::class,
        DoNotIncludeArchives::class],
    packages = ["com.rafaelbaetapena.archunitkotlin"],
    packagesOf = [ArchitectureTest::class]
)
class ArchitectureTest {
    @ArchTest
    val noClassesShouldResideInAPackageConfig =
        noClasses().should().resideInAPackage(PackagesConstants.config)
}