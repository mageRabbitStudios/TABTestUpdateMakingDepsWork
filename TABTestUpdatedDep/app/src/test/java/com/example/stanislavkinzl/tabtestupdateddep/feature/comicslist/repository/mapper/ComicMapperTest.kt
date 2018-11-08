package com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.mapper

import com.example.stanislavkinzl.tabtestupdateddep.app.database.remote.GetComicsResponse
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import com.example.stanislavkinzl.tabtestupdateddep.feature.comicslist.repository.ComicMapper
import com.example.stanislavkinzl.tabtestupdateddep.fileToGson
import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicMapperTest {

    @InjectMocks
    private lateinit var subject: ComicMapper

    private lateinit var outputList: List<Comic>
    private lateinit var response: GetComicsResponse

    @Test
    fun `map() - maps comic list successfully`() {
        //given
        response = fileToGson(allComicsJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(2)
        Assertions.assertThat(outputList[0]).isEqualTo(spiderman)
        Assertions.assertThat(outputList[1]).isEqualTo(batman)
    }

    @Test
    fun `map() - maps without name`() {
        //given
        response = fileToGson(noNameJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(1)
        Assertions.assertThat(outputList[0]).isEqualTo(spiderman_without_name)
    }

    @Test
    fun `map() - returns null because missing thumbnail`() {
        //given
        response = fileToGson(noThumbJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(0)
    }

    @Test
    fun `map() - returns null because missing path`() {
        //given
        response = fileToGson(noPathJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(0)
    }

    private fun logOutputList() {
        System.out.println(outputList.toString())
    }

    private fun assertThatOutputListSizeIs(expected: Int) {
        Assertions.assertThat(outputList.size).isEqualTo(expected)
    }
}