package com.feet.network

import com.example.viewpagerdemo.pojo.AlbumModel
import com.example.viewpagerdemo.pojo.FirstModel
import com.example.viewpagerdemo.pojo.LyricsModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    @GET("chart.artists.get?")
    fun getFirstApi(
        @Query("page") page : Int,
        @Query("page_size") pageSize: Int,
        @Query("country") country: String,
        @Query("apikey") apikey: String
    ): Call<FirstModel>


    @GET("chart.tracks.get?")
    fun getLyricsApi(
        @Query(" chart_name") chartName: String,
        @Query(" page") page: Int,
        @Query(" page_size") pageSize: Int,
        @Query(" country") country: String,
        @Query(" f_has_lyrics") hasLyrics: Int,
        @Query(" apikey") apikey: String
    ): Call<LyricsModel>


    @GET("artist.albums.get?")
    fun getAlbumApi(
        @Query(" artist_id") artistId: Int,
        @Query(" s_release_date") releaseDate: String,
        @Query(" g_album_name") albumName: Int,
        @Query(" apikey") apikey: String
    ) : Call<AlbumModel>

}