package com.rafaelbaetapena.archunitkotlin.architecture

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(
    importOptions = [
        ImportOption.DoNotIncludeTests::class,
        ImportOption.DoNotIncludeJars::class,
        ImportOption.DoNotIncludeArchives::class],
    packages = ["com.rafaelbaetapena.archunitkotlin"],
    packagesOf = [ArchitectureTest::class]
)
class ConfigTest {

    @ArchTest
    val noClassesShouldResideInAPackageConfig: ArchRule =
        ArchRuleDefinition.noClasses().should().resideInAPackage(packageName)

    companion object {
        const val packageName: String = "..config"
        const val deepPackageName: String = "$packageName.."
    }
}