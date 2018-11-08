package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain.FetchComicsUseCase
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.ComicRepository
import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicsViewModelImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockRepository: ComicRepository

    private lateinit var subject: ComicsViewModelImpl

    @Mock
    private lateinit var mockFetchComicsUseCase: FetchComicsUseCase

    private val testComicsList: List<Comic> = listOf(
        Comic(name = "TestC", url = "TestUrl", pageCount = 10),
        Comic(name = "TestC", url = "TestUrl", pageCount = 10)
    )

    @Before
    fun setUp() {
        subject = ComicsViewModelImpl(mockFetchComicsUseCase)
    }

    @Test
    fun `onFetchComicsResult() - Success`() {
        subject.onFetchComicsResult(FetchComicsUseCase.Result.Success(testComicsList))
        Assertions.assertThat(subject.state().value).isEqualTo(ComicsViewModel.State.FetchMemesSuccess(testComicsList))
    }

    @Test
    fun `onFetchComicsResult() - Error`() {
        subject.onFetchComicsResult(FetchComicsUseCase.Result.Error)
        Assertions.assertThat(subject.state().value).isEqualTo(ComicsViewModel.State.FetchMemesError)
    }

}