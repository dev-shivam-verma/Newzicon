package com.dev_shivam.newzicon.home.data.model

import com.dev_shivam.newzicon.home.data.model.dataTransferObjects.Multimedia

data class Article(
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
    val url: String
)