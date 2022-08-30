package com.unknown.onepointtest.di

import com.google.gson.GsonBuilder
import com.unknown.onepointtest.data.remote.TreeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ) : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetroFit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(
            GsonBuilder().serializeNulls().create()
        ))
        .baseUrl("https://opendata.paris.fr/api/v2/")
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideTreeApi(
        retrofit: Retrofit
    ) : TreeApi = retrofit.create(TreeApi::class.java)

}