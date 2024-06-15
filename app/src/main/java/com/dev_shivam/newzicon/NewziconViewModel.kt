package com.dev_shivam.newzicon

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev_shivam.newzicon.core.util.Resource
import com.dev_shivam.newzicon.home.data.repositories.NytTopStoriesNetworkRepository
import com.dev_shivam.newzicon.home.domain.NykTopStoriesUseCase
import com.dev_shivam.newzicon.home.presentation.states.HomeScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



class NewziconViewModel @Inject constructor(
    val nytTopStoriesRepo: NytTopStoriesNetworkRepository
) : ViewModel() {

    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState = _homeScreenState.asStateFlow()

    private val _newziconStates = MutableStateFlow(NewziconStates.LOADING)
    val newziconStates = _newziconStates.asStateFlow()


    fun fetchTopStories(section: NEWS_SECTION = NEWS_SECTION.WORLD) {
        viewModelScope.launch(Dispatchers.IO) {
            val resourse =
                nytTopStoriesRepo.getNytTopStories(section.toString())

            _newziconStates.update { NewziconStates.LOADING }



            when (resourse) {
                is Resource.Success -> {
                    val newHomeNewsList = NykTopStoriesUseCase().getListOfHomeNews(resourse.data!!)
                    _homeScreenState.update {
                        it.copy(
                            homeNewsList = newHomeNewsList)
                    }
                    _newziconStates.update { NewziconStates.SUCCESS }
                    Log.d("NewziconViewModel", "fetchTopStories: ${resourse.data}")
                }

                is Resource.Error -> {
                    Log.e("NewziconViewModel", "whileFetchingTopStories: ${resourse.message}")
                    _newziconStates.update { NewziconStates.ERROR }
                }
            }
        }
    }


    fun onClickSection(section: NEWS_SECTION){
        viewModelScope.launch {

            // removes the previous top stories list
            _homeScreenState.update {
                it.copy(
                    homeNewsList = emptyList(),
                    selectedSection = section
                )
            }

            // fetches the new requested list
            fetchTopStories(section)
        }
    }
}

enum class NewziconStates {
    LOADING,
    SUCCESS,
    ERROR
}