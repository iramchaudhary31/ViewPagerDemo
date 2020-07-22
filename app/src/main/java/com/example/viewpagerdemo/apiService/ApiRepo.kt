package com.feet.network


import com.example.viewpagerdemo.pojo.AlbumModel
import com.example.viewpagerdemo.pojo.FirstModel
import com.example.viewpagerdemo.pojo.LyricsModel
import com.feet.utils.CommonUtils.parseError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepo {
    companion object {
        private var ApiRepoInstance: ApiRepo? = null
        fun getInstance() = ApiRepoInstance
            ?: ApiRepo().also {
                ApiRepoInstance = it
            }
    }

        fun firstApi(onResult: (isSuccess: Boolean, response: Any?) -> Unit) {
        ApiClient.getClient().getFirstApi(1,3,"in","e20b23ce7124446480dc57253badd636")
            .enqueue(object : Callback<FirstModel> {
                override fun onFailure(call: Call<FirstModel>, t: Throwable) {
                    onResult(false, t?.message)
                }

                override fun onResponse(call: Call<FirstModel>, response: Response<FirstModel>?) {
                    if (response != null && response.isSuccessful) {
                        onResult(true, response.body())
                    } else {
                        onResult(false, parseError(response))

                    }
                }
            }
            )
    }

    fun apiLyrics(onResult: (isSuccess: Boolean, response: Any?) -> Unit){
        ApiClient.getLyrics().getLyricsApi("top",1,5,"in",1,"e20b23ce7124446480dc57253badd636")
            .enqueue(object : Callback<LyricsModel>{
            override fun onFailure(call: Call<LyricsModel>, t: Throwable) {
                onResult(false, t?.message)
            }

            override fun onResponse(call: Call<LyricsModel>, response: Response<LyricsModel>) {
                if (response != null && response.isSuccessful) {
                    onResult(true, response.body())
                } else {
                    onResult(false, response)
                }
            }
        })
    }

    fun apiAlbum(onResult: (isSuccess: Boolean, response: Any?) -> Unit){
        ApiClient.getAlbum().getAlbumApi(1039,"desc",1,"e20b23ce7124446480dc57253badd636")
            .enqueue(object : Callback<AlbumModel>{
                override fun onFailure(call: Call<AlbumModel>, t: Throwable) {
                    onResult(false,t?.message)
                }
                override fun onResponse(call: Call<AlbumModel>, response: Response<AlbumModel>) {
                   if (response!= null && response.isSuccessful){
                       onResult(true,response.body())
                   }else
                       onResult(false,response)
                }

            }
        )
    }
}