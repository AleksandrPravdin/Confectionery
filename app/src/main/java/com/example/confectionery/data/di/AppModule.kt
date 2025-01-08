package com.example.confectionery.data.di

import com.example.confectionery.data.remote.api.ConfectioneryApi
import com.example.confectionery.data.repository.CharacteristicsRepositoryImpl
import com.example.confectionery.data.repository.CompositionRepositoryImpl
import com.example.confectionery.data.repository.ConfManufRepositoryImpl
import com.example.confectionery.data.repository.ConfectioneryRepositoryImpl
import com.example.confectionery.data.repository.ConsistencyRepositoryImpl
import com.example.confectionery.data.repository.FormRepositoryImpl
import com.example.confectionery.data.repository.ManufacturerRepositoryImpl
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

    @Provides
    @Singleton
    fun provideCompositionRepository(api: ConfectioneryApi): CompositionRepositoryImpl {
        return CompositionRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideConsistencyRepository(api: ConfectioneryApi): ConsistencyRepositoryImpl {
        return ConsistencyRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideManufacturerRepository(api: ConfectioneryApi): ManufacturerRepositoryImpl {
        return ManufacturerRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFormRepository(api: ConfectioneryApi): FormRepositoryImpl {
        return FormRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCharacteristicsRepository(api: ConfectioneryApi): CharacteristicsRepositoryImpl {
        return CharacteristicsRepositoryImpl(api)
    }
    @Provides
    @Singleton
    fun provideConfManufRepository(api: ConfectioneryApi): ConfManufRepositoryImpl {
        return ConfManufRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideConfectioneryRepository(api: ConfectioneryApi): ConfectioneryRepositoryImpl {
        return ConfectioneryRepositoryImpl(api)
    }
}