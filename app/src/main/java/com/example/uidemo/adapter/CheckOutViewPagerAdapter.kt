package com.example.uidemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

class CheckOutViewPagerAdapter( fm : FragmentManager) : FragmentPagerAdapter(fm) {

    var fragmentName  = arrayListOf<String>()
    var fragments = arrayListOf<Fragment>()

    fun submitData(fragmentName : String , fragment: Fragment){
        this.fragmentName.add(fragmentName)
        this.fragments.add(fragment)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentName[position]
    }


}