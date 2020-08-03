package com.appham.geographygenius.network

import com.appham.geographygenius.domain.entities.PlacesDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
            retrofitClient("https://donfuxx.github.io/GeographyGenius/", httpClient(BuildConfig.DEBUG))
    }
    single {
        (debug: Boolean) -> httpClient(debug)
    }
    single<PlacesApi> {
        get<Retrofit>().create(PlacesApi::class.java)
    }
    single {
        RemotePlacesDataSource(get())
    }
    single<PlacesDataSource> {
        RemotePlacesDataSource(get())
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
        .build()