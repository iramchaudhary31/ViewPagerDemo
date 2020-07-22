package com.example.viewpagerdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feet.network.ApiRepo

class HomeViewModel : ViewModel() {
    var isLoading = MutableLiveData<Boolean>()
    var response = MutableLiveData<Any>()


    fun getData() {
        isLoading.value = true
        ApiRepo.getInstance().firstApi() { success, result ->

                isLoading.value = false
                response.value = result


        }
    }

    fun getLyricsData(){
        isLoading.value = true
        ApiRepo.getInstance().apiLyrics { isSuccess, result ->

            isLoading.value = false
            response.value = result
        }

    }

    fun getAlbumData(){
        isLoading.value = true
        ApiRepo.getInstance().apiAlbum() { isSuccess, result ->

            isLoading.value = false
            response.value = result
        }

    }
}