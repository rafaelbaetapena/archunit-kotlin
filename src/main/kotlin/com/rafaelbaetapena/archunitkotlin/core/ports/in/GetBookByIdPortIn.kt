package com.rafaelbaetapena.archunitkotlin.core.ports.`in`

import com.rafaelbaetapena.archunitkotlin.core.domain.Book
import java.util.UUID

interface GetBookByIdPortIn {
    fun execute(id: UUID): Book
}