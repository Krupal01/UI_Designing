package com.example.uidemo.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.uidemo.R
import com.example.uidemo.adapter.ImageViewPagerAdapter
import com.example.uidemo.adapter.ProductOptionAdapter
import com.example.uidemo.adapter.ProductSpecificationAdapter
import com.example.uidemo.adapter.WishListAdapter
import com.example.uidemo.databinding.FragmentGroupedProductDetailsBinding
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.FunctionDataItems
import com.google.android.material.tabs.TabLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GroupedProductDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GroupedProductDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    private lateinit var binding : FragmentGroupedProductDetailsBinding
    private lateinit var textCartMenuBudge : TextView
    private var dotscount : Int = 0
    private lateinit var dots: Array<AppCompatImageView>
    private var productOptionAdapter = ProductOptionAdapter()
    private var recentListAdapterMain= WishListAdapter()
    private var recentListAdapterProductDetails= WishListAdapter()
    private var productSpecificationAdapter = ProductSpecificationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGroupedProductDetailsBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.Notificationtoolbar.navigationIcon = resources.getDrawable(R.drawable.custom_navigation_icon,null)

        setCollapsingImgViewPager()
        setProductOptionRecycler()
        setRecentRecyclerMain()
        setProductSpecification()
        setProductDetails()
        setProductReview()
        setProductDetailsTabs()
        setProductDetailsLayoutButtons()


    }

    private fun setProductDetailsLayoutButtons() {
        binding.btnSeeSpecification.setOnClickListener {
            if (binding.layoutSpecification.root.visibility == View.VISIBLE){
                setLayoutSpecification(layoutSpecificationVisible = false, layoutProductDetailsVisible = false, layoutItemReviewVisible = false)
            }else{
                setLayoutSpecification(layoutSpecificationVisible = true, layoutProductDetailsVisible = false, layoutItemReviewVisible = false)
            }
        }
        binding.btnSeeProductDetails.setOnClickListener {
            if (binding.layoutProductDetails.root.visibility == View.VISIBLE){
                setLayoutSpecification(layoutSpecificationVisible = false, layoutProductDetailsVisible = false, layoutItemReviewVisible = false)
            }else{
                setLayoutSpecification(layoutSpecificationVisible = false, layoutProductDetailsVisible = true, layoutItemReviewVisible = false)
            }
        }
        binding.btnSeeReview.setOnClickListener {
            if (binding.layoutItemReview.root.visibility == View.VISIBLE){
                setLayoutSpecification(layoutSpecificationVisible = false, layoutProductDetailsVisible = false, layoutItemReviewVisible = false)
            }else{
                setLayoutSpecification(layoutSpecificationVisible = false, layoutProductDetailsVisible = false, layoutItemReviewVisible = true)
            }
        }
    }

    private fun setProductDetailsTabs() {
        binding.layoutSpecification.root.visibility = View.VISIBLE
        binding.layoutProductDetails.root.visibility = View.GONE
        binding.layoutItemReview.root.visibility = View.GONE
        binding.btnSeeSpecification.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)

        binding.tabLayoutProductDetails.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        binding.mainScrollView.smoothScrollTo(0,binding.labelLayoutSpecification.top)
                        setLayoutSpecification(
                            layoutSpecificationVisible = true,
                            layoutProductDetailsVisible = false,
                            layoutItemReviewVisible = false
                        )
                    }
                    1 -> {
                        binding.mainScrollView.smoothScrollTo(0,binding.labelLayoutProductDetails.top)
                        setLayoutSpecification(
                            layoutSpecificationVisible = false,
                            layoutProductDetailsVisible = true,
                            layoutItemReviewVisible = false
                        )
                    }
                    2 -> {
                        binding.mainScrollView.smoothScrollTo(0,binding.labelLayoutReview.top)
                        setLayoutSpecification(
                            layoutSpecificationVisible = false,
                            layoutProductDetailsVisible = false,
                            layoutItemReviewVisible = true
                        )
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setLayoutSpecification(
        layoutSpecificationVisible: Boolean,
        layoutProductDetailsVisible: Boolean,
        layoutItemReviewVisible: Boolean
    ) {
        binding.layoutSpecification.root.visibility = if (layoutSpecificationVisible) View.VISIBLE else View.GONE
        binding.layoutProductDetails.root.visibility = if (layoutProductDetailsVisible) View.VISIBLE else View.GONE
        binding.layoutItemReview.root.visibility = if (layoutItemReviewVisible) View.VISIBLE else View.GONE

        when {
            layoutSpecificationVisible -> binding.tabLayoutProductDetails.getTabAt(0)?.select()
            layoutProductDetailsVisible -> binding.tabLayoutProductDetails.getTabAt(1)?.select()
            layoutItemReviewVisible -> binding.tabLayoutProductDetails.getTabAt(2)?.select()
        }

        binding.btnSeeSpecification.setImageResource(if (layoutSpecificationVisible) R.drawable.ic_baseline_keyboard_arrow_up_24 else R.drawable.ic_baseline_keyboard_arrow_down_24)
        binding.btnSeeProductDetails.setImageResource(if (layoutProductDetailsVisible) R.drawable.ic_baseline_keyboard_arrow_up_24 else R.drawable.ic_baseline_keyboard_arrow_down_24)
        binding.btnSeeReview.setImageResource(if (layoutItemReviewVisible) R.drawable.ic_baseline_keyboard_arrow_up_24 else R.drawable.ic_baseline_keyboard_arrow_down_24)

    }

    private fun setProductReview() {
        binding.layoutItemReview.reviews = FakeData.fakeReview
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setProductDetails() {

        binding.layoutProductDetails.webProductDetails.settings.domStorageEnabled = true
        binding.layoutProductDetails.webProductDetails.settings.javaScriptEnabled = true

        binding.layoutProductDetails.webProductDetails.loadUrl("file:///android_asset/WebPages/product_details.html")


        val recentListlayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.layoutProductDetails.rcvRelatedList.layoutManager = recentListlayoutManager
        binding.layoutProductDetails.rcvRelatedList.adapter = recentListAdapterProductDetails
        recentListAdapterProductDetails.submitData(FakeData.data)
    }

    private fun setProductSpecification() {
        val layoutManager = LinearLayoutManager(context)
        binding.layoutSpecification.rcvSpecification.layoutManager = layoutManager
        binding.layoutSpecification.rcvSpecification.adapter = productSpecificationAdapter
        productSpecificationAdapter.submitData(FakeData.fakeSpecificationData)
    }

    private fun setRecentRecyclerMain() {
        val recentListlayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcvRelatedList.layoutManager = recentListlayoutManager
        binding.rcvRelatedList.adapter = recentListAdapterMain
        recentListAdapterMain.submitData(FakeData.data)

    }

    private fun setProductOptionRecycler() {
        val layoutManager = LinearLayoutManager(context)
        binding.rcvOptions.layoutManager = layoutManager
        binding.rcvOptions.adapter = productOptionAdapter
        binding.rcvOptions.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        productOptionAdapter.submitData(FunctionDataItems.productOption)
    }

    private fun setCollapsingImgViewPager() {
        val imgViewPagerAdapter = ImageViewPagerAdapter(requireContext())
        binding.imgViewPager.adapter = imgViewPagerAdapter

        dotscount = imgViewPagerAdapter.count
        dots = Array(dotscount){AppCompatImageView(requireContext())}

        for (i in 0 until dotscount) {
            dots[i] = AppCompatImageView(requireContext())
            dots[i].setImageResource(R.drawable.ic_inactive_dots_8)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            binding.layoutImgSliderDots.addView(dots[i], params)
        }
        dots[0].setImageResource(R.drawable.ic_active_dots_8)

        binding.imgViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i].setImageResource(R.drawable.ic_inactive_dots_8)
                }
                dots[position].setImageResource(R.drawable.ic_active_dots_8)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.menu_grouped_product_details,menu)
        val menuItemCart : MenuItem = menu.findItem(R.id.menuItemCart)
        val actionView : View = menuItemCart.actionView
        textCartMenuBudge = actionView.findViewById(R.id.cart_badge) as TextView
        actionView.setOnClickListener { onOptionsItemSelected(menuItemCart) }
        setupMenuBadge(2)
    }

    private fun setupMenuBadge(i: Int){
        if (i == 0) {
            if (textCartMenuBudge.visibility != View.GONE) {
                textCartMenuBudge.visibility = View.GONE
            }
        } else {
            textCartMenuBudge.text = i.toString()
            if (textCartMenuBudge.visibility != View.VISIBLE) {
                textCartMenuBudge.visibility = View.VISIBLE
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                findNavController().popBackStack()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GroupedProductDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GroupedProductDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}