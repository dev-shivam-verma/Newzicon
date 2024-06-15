package com.dev_shivam.newzicon.home.data.model

import com.dev_shivam.newzicon.home.data.model.dataTransferObjects.Result


fun Result.toArticleEntity() : ArticleEntity{
    return ArticleEntity(
        abstract = abstract,
        createdDate = created_date,
        itemType = item_type,
        multimedia = multimedia,
        publishedDate = published_date,
        section = section,
        shortUrl = short_url,
        subsection = subsection,
        title = title,
        updatedDate = updated_date,
        uri = uri,
        url = url
    )
}


fun ArticleEntity.toArticle() : Article {
    return Article(
        abstract = abstract,
        createdDate = createdDate,
        itemType = itemType,
        multimedia = multimedia,
        publishedDate = publishedDate,
        section = section,
        shortUrl = shortUrl,
        subsection = subsection,
        title = title,
        updatedDate = updatedDate,
        uri = uri,
        url = url
    )
}