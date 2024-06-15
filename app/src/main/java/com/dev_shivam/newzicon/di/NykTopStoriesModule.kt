package com.dev_shivam.newzicon.di

import com.dev_shivam.newzicon.NYT_TOPSTORIES_BASE_URL
import com.dev_shivam.newzicon.home.data.apiInterfaces.NytTopStoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NykTopStoriesModule {



    @Provides
    fun provideNykTopStoriesService(): NytTopStoriesService {
        return Retrofit.Builder()
            .baseUrl(NYT_TOPSTORIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NytTopStoriesService::class.java)
    }
}