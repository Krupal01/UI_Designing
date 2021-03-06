package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.WishListAdapter
import com.example.uidemo.databinding.FragmentAccountBinding
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
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

    private lateinit var binding: FragmentAccountBinding
    private lateinit var wishListlayoutManager: LinearLayoutManager
    private lateinit var recentListlayoutManager: LinearLayoutManager
    private var wishListAdapter= WishListAdapter()
    private var recentListAdapter= WishListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.toolbar,true)

        recentListlayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        wishListlayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        setWishlistRecycler()
        setRecentRecycler()
        wishListAdapter.submitData(FakeData.data)
        recentListAdapter.submitData(FakeData.data)

        binding.btnWishListAll.setOnClickListener {
            (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.whishListFragment)
        }

        binding.btnRecentListAll.setOnClickListener {
            (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.recentlyViewedFragment)
        }

    }

    private fun setRecentRecycler() {
        binding.rcvRecentList.layoutManager = recentListlayoutManager
        binding.rcvRecentList.adapter = recentListAdapter
    }

    private fun setWishlistRecycler() {
        binding.rcvWishList.layoutManager = wishListlayoutManager
        binding.rcvWishList.adapter = wishListAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}