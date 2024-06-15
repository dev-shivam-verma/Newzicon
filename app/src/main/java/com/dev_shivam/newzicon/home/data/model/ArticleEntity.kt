package com.dev_shivam.newzicon.home.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dev_shivam.newzicon.home.data.model.dataTransferObjects.Multimedia


@Entity(tableName = "article")
data class ArticleEntity(
    val `abstract`: String,
    val createdDate: String,
    val itemType: String,
    val multimedia: List<Multimedia>,
    val publishedDate: String,
    val section: String,
    val shortUrl: String,
    val subsection: String,
    val title: String,
    val updatedDate: String,
    val uri: String,
    val url: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
