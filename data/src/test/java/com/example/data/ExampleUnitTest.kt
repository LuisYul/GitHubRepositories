package com.example.data

import android.util.Log
import com.example.data.remote.response.AuthorResponse
import com.example.data.remote.response.RepositoryResult
import com.example.data.utils.DataMapper
import org.junit.Test

import org.junit.Assert.*
import org.mockito.kotlin.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val mockMapper = mock<DataMapper>()

    @Test
    fun testMapperWhenArrayIsEmpty() {
        val model = mockMapper.mapRepositoryResponseToModel(arrayListOf())
        assertEquals(0, model.size)
    }

    @Test
    fun testMapperWhenArrayIsNotEmpty() {
        val result = RepositoryResult(
            id = 123,
            name = "Name test",
            author = AuthorResponse(login = "Author test"),
            url = "Url test",
        )
        val list = arrayListOf<RepositoryResult>()
        list.add(result)
        val model = mockMapper.mapRepositoryResponseToModel(list)
        assertEquals(1, model.size)
    }

}