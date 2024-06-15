package com.dev_shivam.newzicon.home.data.room

import androidx.room.Database
import com.dev_shivam.newzicon.home.data.model.ArticleEntity


@Database(
    entities = [ArticleEntity::class],
    version = 1
)
abstract class ArticleDatabase {
     abstract val dao: ArticleDao
}