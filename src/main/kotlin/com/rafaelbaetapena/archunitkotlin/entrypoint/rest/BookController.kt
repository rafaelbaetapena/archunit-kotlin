package com.rafaelbaetapena.archunitkotlin.entrypoint.rest

import com.rafaelbaetapena.archunitkotlin.core.domain.Book
import com.rafaelbaetapena.archunitkotlin.core.ports.`in`.GetBookByIdPortIn
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/books")
class BookController(
    val getBookByIdPortIn: GetBookByIdPortIn
) {
    @GetMapping("{id}")
    fun getById(@PathVariable id: UUID): Book {
        return getBookByIdPortIn.execute(id)
    }
}