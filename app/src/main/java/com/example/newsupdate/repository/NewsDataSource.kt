package com.example.newsupdate.repository

import Articles
import androidx.paging.PagingSource
import com.example.newsupdate.interfaces.NewsService
import com.example.newsupdate.model.NewsBase
import retrofit2.HttpException
import java.io.IOException

class NewsDataSource(val newsService: NewsService):PagingSource<Int,NewsBase>()
{
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsBase>
    {
        val page=params.key?:1
        return try {
            val  response=newsService.getNews(page,params.loadSize)
            LoadResult.Page(
                response, prevKey = if (page == 1) null else page-1,
                nextKey = if(response.isEmpty()) null else page+1
            )
        } catch (exception:IOException)
        {
            return LoadResult.Error(exception)
        }
        catch (exception:HttpException)
        {
            return LoadResult.Error(exception)
        }


    }

}