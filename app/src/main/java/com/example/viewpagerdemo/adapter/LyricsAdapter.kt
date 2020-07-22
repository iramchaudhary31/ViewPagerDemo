package com.example.viewpagerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.pojo.LyricsModel
import kotlinx.android.synthetic.main.item_artist.view.*

class LyricsAdapter(var lyricsList: ArrayList<LyricsModel.Message.Body.Track>) : RecyclerView.Adapter<LyricsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_artist,parent,false))
    }

    override fun getItemCount(): Int {
        return lyricsList.size
    }

    override fun onBindViewHolder(holder: LyricsAdapter.ViewHolder, position: Int) {
              holder.bindItem(lyricsList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bindItem(lyrics: LyricsModel.Message.Body.Track){
                itemView.tv_artist_name.text = lyrics.track.trackName
            }
    }
}