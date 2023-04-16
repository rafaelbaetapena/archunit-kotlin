package com.rafaelbaetapena.archunitkotlin.architecture.dataprovider

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class DataProviderRules {
    @ArchTest
    val noClassesShouldResideInAPackageDataProvider: ArchRule =
        noClasses().should().resideInAPackage(PackagesConstants.dataProviderPackageName)
}