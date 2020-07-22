package com.example.viewpager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.pojo.FirstModel
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistAdpter(var list: ArrayList<FirstModel.Message.Body.Artist>) :
    RecyclerView.Adapter<ArtistAdpter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdpter.ViewHolder {
//        var inflater = LayoutInflater.from(parent.context)
//        var binding =
//            DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.item_artist, parent, false)
//        return ViewHolder(binding as ItemArtistBinding)
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ArtistAdpter.ViewHolder, position: Int) {
        var pojo = list[position]
        holder.tv_artist_name.setText(pojo.artist.artistName)
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tv_artist_name = view.tv_artist_name
    }

}