package com.example.uidemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.uidemo.R
import com.example.uidemo.databinding.LayoutImagePagerBinding

class ImageViewPagerAdapter( val context: Context) : PagerAdapter() {

    private lateinit var layoutInflater : LayoutInflater
    private var images = arrayListOf(
        R.drawable.barcode,
        R.drawable.card_bg_image,
        R.drawable.ic_launcher_background
    )

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val  view = layoutInflater.inflate(R.layout.layout_image_pager,null)
        val imageView = view.findViewById(R.id.imageView) as AppCompatImageView
        imageView.setImageResource(images[position])

        val viewPager = container as ViewPager
        viewPager.addView(view,0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}