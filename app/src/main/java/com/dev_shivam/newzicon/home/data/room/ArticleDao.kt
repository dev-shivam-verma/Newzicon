package com.dev_shivam.newzicon.home.data.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.dev_shivam.newzicon.home.data.model.ArticleEntity


@Dao
interface ArticleDao {

    @Upsert
    suspend fun upsertAll(articles: List<ArticleEntity>)

    @Query("SELECT * FROM article")
    fun pagingSource(): PagingSource<Int, ArticleEntity>


    @Query("DELETE FROM article")
    suspend fun clearAll()
}