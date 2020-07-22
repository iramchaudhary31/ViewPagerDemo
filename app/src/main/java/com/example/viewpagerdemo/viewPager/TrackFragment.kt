package com.example.viewpager.viewPager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.adapter.LyricsAdapter
import com.example.viewpagerdemo.pojo.LyricsModel
import com.example.viewpagerdemo.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_lyrics.*

class TrackFragment : Fragment() {

     var viewModelLyrics : HomeViewModel? = null
    var list = ArrayList<LyricsModel.Message.Body.Track>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_lyrics, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelLyrics = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModelLyrics!!.getLyricsData()

        Log.e("see here", "on create")
    }

    override fun onResume() {
        super.onResume()
        Log.e("see here", "on resume")
    }

    override fun onStart() {
        super.onStart()
        Log.e("see here", "on start")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_lyrics.layoutManager = LinearLayoutManager(activity)

        viewModelLyrics!!.response.observe(activity!!, Observer { response ->
            if (response is LyricsModel){
                if (response.message.header.statusCode == 200){
                    list.addAll(response.message.body.trackList)
                    rv_lyrics.adapter = LyricsAdapter(list)
                }
            }
            else {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        viewModelLyrics!!.isLoading.observe(activity!!, Observer { isLoader ->
            if (isLoader) {
                progress_lyrics.visibility = View.VISIBLE
            } else {
                progress_lyrics.visibility = View.GONE
            }
        })

    }

}