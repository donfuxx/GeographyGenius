package com.appham.geographygenius.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        (baseUrl: String, httpClient: OkHttpClient) -> retrofitClient(baseUrl, httpClient)
    }
    single {
        (debug: Boolean) -> httpClient(debug)
    }
    single<PlacesApi> {
        (retrofit: Retrofit) -> retrofit.create(PlacesApi::class.java)
    }
}

private fun httpClient(debug: Boolean): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder()
    if (debug) {
        clientBuilder.addInterceptor(
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
    }
    return clientBuilder.build()
}

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()