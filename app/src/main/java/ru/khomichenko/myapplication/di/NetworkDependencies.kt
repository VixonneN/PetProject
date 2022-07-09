package ru.khomichenko.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.khomochenko.data.network.api_key.ApiKeyInterceptor
import ru.khomochenko.data.network.data_source.PhotoApi
import ru.khomochenko.data.network.repository.PhotosNetworkRepositoryImpl
import ru.khomochenko.domain.network.repository.PhotosNetworkRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDependencies {

    private const val BASE_URL = "https://api.themotivate365.com/"

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideClient() : OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(ApiKeyInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : PhotoApi =
        retrofit.create(PhotoApi::class.java)

    @Provides
    @Singleton
    fun provideNetworkRepository(api: PhotoApi) : PhotosNetworkRepository =
        PhotosNetworkRepositoryImpl(api)

}