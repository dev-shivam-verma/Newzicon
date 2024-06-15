package com.dev_shivam.newzicon.home.data.model.dataTransferObjects

data class NytTopStoriesResult(
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<Result>,
    val section: String,
    val status: String
)