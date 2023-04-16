package com.rafaelbaetapena.archunitkotlin.architecture.entrypoint

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

class RestRules {
    @ArchTest
    val classesThatResideInAPackageRestShouldHaveSimpleNameEndingWithController: ArchRule =
        classes().that().resideInAPackage(PackagesConstants.entrypointRestPackageName)
            .should().haveSimpleNameEndingWith("Controller")
            .allowEmptyShould(true)
            .because("Controllers are need to ending with Controller")

    @ArchTest
    val classesThatResideInAPackageRestShouldBeAnnotatedWithRestControllerAndRequestMapping: ArchRule =
        classes().that().resideInAPackage(PackagesConstants.entrypointRestPackageName)
            .should().beAnnotatedWith(RestController::class.java)
            .andShould().beAnnotatedWith(RequestMapping::class.java)
            .allowEmptyShould(true)
            .because("Controllers are need to be annotated with @RestController and @RequestMapping")
}