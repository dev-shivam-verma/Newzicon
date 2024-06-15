package com.dev_shivam.newzicon.home.data.repositories

import com.dev_shivam.newzicon.BuildConfig
import com.dev_shivam.newzicon.core.util.Resource
import com.dev_shivam.newzicon.home.data.apiInterfaces.NytTopStoriesService
import com.dev_shivam.newzicon.home.data.model.dataTransferObjects.NytTopStoriesResult
import retrofit2.awaitResponse
import javax.inject.Inject

class NytTopStoriesNetworkRepository @Inject constructor(
    val service: NytTopStoriesService
) {
    suspend fun getNytTopStories(section: String): Resource<NytTopStoriesResult> {
        val apiKey = BuildConfig.nyk_topstories_api_key

        return try {
            val response = service.getTopStories(section, apiKey).awaitResponse()

            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error("Response is null")
            } else {

                Resource.Error(response.message())

            }
        } catch (e: Exception) {

            Resource.Error(e.message ?: "An error occurred")

        }
    }
}