package com.rafaelbaetapena.archunitkotlin.architecture.config

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class ConfigRules {
    @ArchTest
    val noClassesShouldResideInAPackageConfig: ArchRule =
        noClasses().should().resideInAPackage(PackagesConstants.configPackageName)
}