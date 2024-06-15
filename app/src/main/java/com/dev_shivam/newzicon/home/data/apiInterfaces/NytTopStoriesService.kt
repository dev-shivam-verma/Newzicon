package com.dev_shivam.newzicon.home.data.apiInterfaces

import com.dev_shivam.newzicon.home.data.model.dataTransferObjects.NytTopStoriesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NytTopStoriesService {
    @GET("{section}.json")
    fun getTopStories(
        @Path("section") section: String,
        @Query("api-key") apiKey: String
    ): Call<NytTopStoriesResult>
}