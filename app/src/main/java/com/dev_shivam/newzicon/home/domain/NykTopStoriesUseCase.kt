package com.dev_shivam.newzicon.home.domain

import com.dev_shivam.newzicon.home.data.model.dataTransferObjects.NytTopStoriesResult
import com.dev_shivam.newzicon.home.presentation.models.HomeNews

class NykTopStoriesUseCase {
    fun getListOfHomeNews(topStoriesResult: NytTopStoriesResult): List<HomeNews> {
        return return topStoriesResult.results
            .filterNot { it.multimedia.isNullOrEmpty() } // Filter out items with empty multimedia
            .mapNotNull {
                if (it.multimedia[0].type == "image" || it.multimedia[0].subtype == "photo") {
                    HomeNews(it.title, it.multimedia[0].url)
                } else null // Skip items that don't match the criteria
            }
    }
}