package com.rafaelbaetapena.archunitkotlin.architecture.core

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class PortsRules {
    @ArchTest
    val noClassesShouldResideInAPackageCorePorts: ArchRule =
        noClasses().should().resideInAPackage(PackagesConstants.corePortsPackageName)

    @ArchTest
    val classesThatResideInAPackagePortsInShouldBeInterfaces: ArchRule =
        classes().that().resideInAPackage(PackagesConstants.corePortsInPackageName)
            .should().beInterfaces()
            .andShould().haveSimpleNameEndingWith("PortIn")

    @ArchTest
    val classesThatResideInAPackagePortsOutShouldBeInterfaces: ArchRule =
        classes().that().resideInAPackage(PackagesConstants.corePortsOutPackageName)
            .should().beInterfaces()
            .andShould().haveSimpleNameEndingWith("PortOut")
}