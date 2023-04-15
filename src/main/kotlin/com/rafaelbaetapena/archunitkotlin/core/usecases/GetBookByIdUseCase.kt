package com.rafaelbaetapena.archunitkotlin.core.usecases

import com.rafaelbaetapena.archunitkotlin.core.domain.Book
import com.rafaelbaetapena.archunitkotlin.core.ports.`in`.GetBookByIdPortIn
import com.rafaelbaetapena.archunitkotlin.core.ports.out.BookPortOut
import org.springframework.stereotype.Service
import java.util.*

@Service
class GetBookByIdUseCase(
    val bookPortOut: BookPortOut
): GetBookByIdPortIn {
    override fun execute(id: UUID): Book {
        return bookPortOut.getById(id)
    }
}