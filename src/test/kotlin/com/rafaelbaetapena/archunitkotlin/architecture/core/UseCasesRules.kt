package com.rafaelbaetapena.archunitkotlin.architecture.core

import com.rafaelbaetapena.archunitkotlin.architecture.PackagesConstants
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaMethod
import com.tngtech.archunit.core.domain.JavaModifier
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.ConditionEvents
import com.tngtech.archunit.lang.SimpleConditionEvent
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.freeze.FreezingArchRule
import com.tngtech.archunit.library.freeze.FreezingArchRule.freeze
import java.util.stream.Collectors.toList

class UseCasesRules {
    @ArchTest
    val classesThatResideInAPackageUseCasesHaveSimpleNameEndingWithUseCase: ArchRule =
        classes().that().resideInAPackage(PackagesConstants.coreUseCasesPackageName)
            .should().haveSimpleNameEndingWith("UseCase")

    @ArchTest
    val classesThatResideInAPackageUseCasesHaveOnlyOnePublicMethod: ArchRule =
        classes().that().resideInAPackage(PackagesConstants.coreUseCasesPackageName)
        .should(containOnlyOnePublicMethod())
        .because("Use Cases should have only one business responsibility.")

    private fun containOnlyOnePublicMethod(): ArchCondition<JavaClass> {
        return object : ArchCondition<JavaClass>("Only one public method") {
            override fun check(clazz: JavaClass, events: ConditionEvents) {
                val name: String = clazz.name
                val publicMethods: List<JavaMethod> = clazz.methods.stream()
                    .filter { it.modifiers.contains(JavaModifier.PUBLIC) }
                    .filter { it.name.startsWith("get").not() && it.name.startsWith("set").not() }
                    .collect(toList())

                val satisfied = publicMethods.size == 1
                val message = String.format("Class %s contains %d public methods, when limit is %d",
                            name, publicMethods.size, 1)
                events.add(SimpleConditionEvent(javaClass, satisfied, message))
            }
        }
    }
}