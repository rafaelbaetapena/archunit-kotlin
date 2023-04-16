package com.rafaelbaetapena.archunitkotlin.architecture.core

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class PortRules {
    @ArchTest
    val noClassesShouldResideInAPackageCorePort: ArchRule =
        noClasses().should().resideInAPackage(PackagesConstants.corePortPackageName)
}