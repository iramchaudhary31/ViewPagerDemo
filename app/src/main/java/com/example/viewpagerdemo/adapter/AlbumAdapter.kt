package com.example.viewpagerdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager.adapter.ArtistAdpter
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.pojo.AlbumModel
import kotlinx.android.synthetic.main.item_artist.view.*
import java.util.zip.Inflater

class AlbumAdapter(var list: ArrayList<AlbumModel.Message.Body.Album>):
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           holder.BindItem(list[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun BindItem(albumList: AlbumModel.Message.Body.Album){
               itemView.tv_artist_name.text= albumList.album.albumName
        }
    }
}