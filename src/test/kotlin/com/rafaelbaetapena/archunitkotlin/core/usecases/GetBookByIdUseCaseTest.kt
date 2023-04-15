package com.rafaelbaetapena.archunitkotlin.core.usecases

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.rafaelbaetapena.archunitkotlin.core.domain.Book
import com.rafaelbaetapena.archunitkotlin.core.ports.out.BookPortOut
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class GetBookByIdUseCaseTest {

    @Mock
    lateinit var bookPortOut: BookPortOut

    @InjectMocks
    lateinit var getBookByIdUseCase: GetBookByIdUseCase

    @Test
    fun `get book by id`() {
        val id = UUID.fromString("93e75332-c77c-4b7e-a040-e2aa98cc8911")
        whenever(bookPortOut.getById(any()))
            .thenReturn(Book(id, "Title"))

        val book = getBookByIdUseCase.execute(id)

        assertThat(book).isNotNull
        assertThat(book.id).isEqualTo(id)
        assertThat(book.title).isEqualTo("Title")
    }
}