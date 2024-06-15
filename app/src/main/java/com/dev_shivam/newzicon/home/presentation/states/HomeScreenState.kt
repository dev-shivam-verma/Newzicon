package com.dev_shivam.newzicon.home.presentation.states

import com.dev_shivam.newzicon.NEWS_SECTION
import com.dev_shivam.newzicon.home.presentation.models.HomeNews

data class HomeScreenState(
    val homeNewsList: List<HomeNews> = emptyList(),
    val selectedSection: NEWS_SECTION = NEWS_SECTION.WORLD
)