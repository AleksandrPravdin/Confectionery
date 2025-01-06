package com.example.confectionery.data.di

import com.example.confectionery.data.api.ConfectioneryApi
import com.example.confectionery.data.repository.PartyConfectioneryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConfectioneryApi(): ConfectioneryApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.25.229:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConfectioneryApi::class.java)
    }

    @Provides
    @Singleton
    fun providePartyConfectioneryRepository(api: ConfectioneryApi): PartyConfectioneryRepositoryImpl {
        return PartyConfectioneryRepositoryImpl(api)
    }
}