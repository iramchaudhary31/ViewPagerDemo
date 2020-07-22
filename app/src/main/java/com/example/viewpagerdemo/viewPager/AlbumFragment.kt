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
import com.example.viewpagerdemo.adapter.AlbumAdapter
import com.example.viewpagerdemo.pojo.AlbumModel
import com.example.viewpagerdemo.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_album.*
import kotlinx.android.synthetic.main.fragment_artist.progress
import timber.log.Timber

class AlbumFragment : Fragment() {

    var viewModel: HomeViewModel? = null
    var list = ArrayList<AlbumModel.Message.Body.Album>()
  //  private lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      /*  binding= DataBindingUtil.inflate(inflater, R.layout.fragment_album,container,false)
        binding.homeViewModel = viewModel
        binding.albumFragment= this
        return binding.root*/
       return inflater!!.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_album.layoutManager= LinearLayoutManager(activity)
        rv_album.isNestedScrollingEnabled = false

        viewModel!!.response.observe(activity!!, Observer { response ->
            if (response is AlbumModel){
                if (response.message.header.statusCode == 200){
                    list.clear()
                    list.addAll(response.message.body.albumList)
                    rv_album.adapter= AlbumAdapter(list)
                }else {
                    Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })

        viewModel!!.isLoading.observe(activity!!, Observer { isLoader ->
            if (isLoader) {
                progress.visibility = View.GONE
            } else {
                progress.visibility = View.GONE
            }
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

   // Timber.d("SEE HERE (ON CREATE) ")
        Log.e("see here", "on create")
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel!!.getAlbumData()
    }

    override fun onResume() {
        super.onResume()
        Log.e("see here", "on resume")
    }

    override fun onStart() {
        super.onStart()
        Log.e("see here", "on start")
    }

}