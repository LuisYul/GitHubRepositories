package com.example.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.network.ApiService
import com.example.data.utils.DataMapper
import com.example.domain.model.RepositoryModel
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX: Int = 1

class RemoteDataSource constructor(
    private val apiService: ApiService
) : PagingSource<Int, RepositoryModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryModel> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = apiService.getRepositoriesPaged(
                "kotlin",
                position,
                params.loadSize
            )
            val result = DataMapper.mapRepositoryResponseToModel(response.items)

            LoadResult.Page(
                data = result,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (result.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RepositoryModel>): Int? {
        return state.anchorPosition
    }
}