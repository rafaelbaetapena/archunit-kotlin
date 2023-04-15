package com.rafaelbaetapena.archunitkotlin.core.ports.out

import com.rafaelbaetapena.archunitkotlin.core.domain.Book
import java.util.UUID

interface BookPortOut {
    fun getById(id: UUID): Book
}