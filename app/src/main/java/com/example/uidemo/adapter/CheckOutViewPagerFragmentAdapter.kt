package com.example.uidemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CheckOutViewPagerFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragmentName  = arrayListOf<String>()
    var fragments = arrayListOf<Fragment>()

    fun submitData(fragmentName : String , fragment: Fragment){
        this.fragmentName.add(fragmentName)
        this.fragments.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
    
}