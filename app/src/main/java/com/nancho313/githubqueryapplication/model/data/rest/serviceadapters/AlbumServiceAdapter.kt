package com.nancho313.githubqueryapplication.model.data.rest.serviceadapters

import com.nancho313.githubqueryapplication.model.data.rest.dto.AlbumResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class AlbumServiceAdapter(baseURL: String) {

    private val retrofitClient: Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create()).baseUrl(baseURL).build()

    private val albumService: RetrofitAlbumService =
        retrofitClient.create(RetrofitAlbumService::class.java)

    suspend fun getAllAlbums(): List<AlbumResponse> {

        return albumService.getAlbums().await()
    }

    suspend fun getAlbumById(albumId: Int): AlbumResponse {

        return albumService.getAlbumById(albumId).await()
    }

    interface RetrofitAlbumService {

        @GET("albums")
        fun getAlbums(): Call<List<AlbumResponse>>

        @GET("albums/{id}")
        fun getAlbumById(@Path("id") albumId:Int): Call<AlbumResponse>
    }
}