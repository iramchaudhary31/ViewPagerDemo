package com.example.viewpagerdemo.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager.adapter.ArtistAdpter
import com.example.viewpagerdemo.R
import com.example.viewpagerdemo.databinding.FragmentArtistBinding
import com.example.viewpagerdemo.pojo.FirstModel
import com.example.viewpagerdemo.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_artist.*

//import com.opensooq.supernova.gligar.GligarPicker

class ArtistFragment : Fragment() {

private lateinit var binding: FragmentArtistBinding

    var viewModel: HomeViewModel? = null
    var list = ArrayList<FirstModel.Message.Body.Artist>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       binding.rvArtist.layoutManager = LinearLayoutManager(activity)


        viewModel!!.response.observe(activity!!, Observer { response ->
            if (response is FirstModel) {
                if (response.message.header.statusCode == 200) {
                    list.clear()
                    list.addAll(response.message.body.artistList)
                    binding.rvArtist.adapter = ArtistAdpter(list)
                }
            } else {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        viewModel!!.isLoading.observe(activity!!, Observer { isLoader ->
            if (isLoader) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_artist,container,false)
          binding.homeviewmodel = viewModel
        binding.artistfragment= this
        return binding.root
       // return inflater!!.inflate(R.layout.fragment_home, container, false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialising view model here
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel!!.getData()
    }

//    fun openGallaryCamera() {
//
//        Dexter.withActivity(activity)
//            .withPermissions(
//                Manifest.permission.CAMERA,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.READ_EXTERNAL_STORAGE
//            ).withListener(object : MultiplePermissionsListener {
//
//                override fun onPermissionsChecked(report: MultiplePermissionsReport) {/* ... */
//
//                 //   GligarPicker().requestCode(400).withFragment(this@HomeFragment)
//                   //     .limit(1).show()
//
//                }
//
//                override fun onPermissionRationaleShouldBeShown(
//                    permissions: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
//                    token: PermissionToken?
//                ) {
//                    token!!.continuePermissionRequest()
//                }
//            }).check()
//    }
}