package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.domain

import com.example.stanislavkinzl.tabtestupdateddep.app.SchedulerProvider
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.ComicRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FetchComicsUseCaseImplTest {

    @Mock
    private lateinit var mockComicsRepository: ComicRepository
    @Mock
    private lateinit var mockScheduleProvider: SchedulerProvider

    private lateinit var subject: FetchComicsUseCaseImpl

    @Mock
    private lateinit var mockScheduler: Scheduler
    @Mock
    private lateinit var mockResponse: List<Comic>

    @Before
    fun setUp() {
        subject = FetchComicsUseCaseImpl(mockComicsRepository, mockScheduleProvider)
    }

    @Test
    fun `execute() - comic repository should be called`() {
        BDDMockito.given(mockScheduleProvider.io()).willReturn(mockScheduler)
        BDDMockito.given(mockScheduleProvider.mainThread()).willReturn(mockScheduler)
        BDDMockito.given(mockComicsRepository.fetchComics()).willReturn(Single.just(mockResponse))

        subject.execute()

        BDDMockito.then(mockComicsRepository).should().fetchComics()
        BDDMockito.then(mockComicsRepository).shouldHaveNoMoreInteractions()
    }

}