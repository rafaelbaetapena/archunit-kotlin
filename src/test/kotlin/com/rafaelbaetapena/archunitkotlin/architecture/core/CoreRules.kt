package com.rafaelbaetapena.archunitkotlin.architecture.core

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class CoreRules {
    @ArchTest
    val noClassesShouldResideInAPackageCore: ArchRule =
        noClasses().should().resideInAPackage(PackagesConstants.corePackageName)
}