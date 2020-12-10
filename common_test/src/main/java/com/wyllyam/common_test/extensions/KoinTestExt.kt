package com.wyllyam.common_test.extensions

import org.koin.dsl.ModuleDeclaration
import org.koin.dsl.module
import org.koin.test.KoinTest

fun KoinTest.declare(moduleDeclaration: ModuleDeclaration) {
    val module = module(
        createdAtStart = false,
        override = true,
        moduleDeclaration = moduleDeclaration
    )
    getKoin().loadModules(listOf(module))
}
