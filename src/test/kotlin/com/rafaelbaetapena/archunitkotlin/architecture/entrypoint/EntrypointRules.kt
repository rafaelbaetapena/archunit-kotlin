package com.rafaelbaetapena.archunitkotlin.architecture.entrypoint

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class EntrypointRules {
    @ArchTest
    val noClassesShouldResideInAPackageEntrypoint: ArchRule =
        noClasses().should().resideInAPackage(PackagesConstants.entrypointPackageName)
}