package com.dev_shivam.newzicon.home.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.dev_shivam.newzicon.home.data.apiInterfaces.NytTopStoriesService
import com.dev_shivam.newzicon.home.data.model.Article
import com.dev_shivam.newzicon.home.data.model.ArticleEntity
import com.dev_shivam.newzicon.home.data.room.ArticleDatabase

@OptIn(ExperimentalPagingApi::class)
class ArticleRemoteMediator(
    private val articleDb: ArticleDatabase,
    private val nytTopStoriesService: NytTopStoriesService
): RemoteMediator<Int, ArticleEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleEntity>
    ): MediatorResult {
        return try {

        }
        catch (e: )
    }

}