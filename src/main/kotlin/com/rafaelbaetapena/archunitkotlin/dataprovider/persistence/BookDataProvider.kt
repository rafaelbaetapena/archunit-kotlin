package com.rafaelbaetapena.archunitkotlin.dataprovider.persistence

import com.rafaelbaetapena.archunitkotlin.core.domain.Book
import com.rafaelbaetapena.archunitkotlin.core.ports.out.BookPortOut
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookDataProvider: BookPortOut {
    override fun getById(id: UUID): Book {
        return Book(id, "Title $id")
    }
}