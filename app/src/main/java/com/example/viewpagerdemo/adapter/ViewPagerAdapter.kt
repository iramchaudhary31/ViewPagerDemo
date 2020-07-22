package com.example.viewpager.viewPager


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpagerdemo.viewPager.ArtistFragment

class ViewPagerAdapter(private val myContext: Context, fm: androidx.fragment.app.FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm)  {
    override fun getItem(position: Int): Fragment {
        when (position) {

            1 -> {
                return TrackFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return AlbumFragment()
            }
            else -> return ArtistFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}