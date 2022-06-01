package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.MyOrderItemParentAdapter
import com.example.uidemo.adapter.MyOrderProcessingItemAdapter
import com.example.uidemo.databinding.FragmentMyOrderDetailsBinding
import com.example.uidemo.model.MyOrderItemModel
import com.example.uidemo.model.MyOrderModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyOrderDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyOrderDetailsFragment : Fragment(),MyOrderProcessingItemAdapter.OnOrderItemClick {
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

    private lateinit var binding : FragmentMyOrderDetailsBinding
    private var myOrderItemParentAdapter = MyOrderItemParentAdapter()
    private var myOrderProcessingItemAdapter = MyOrderProcessingItemAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMyOrderDetailsBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        val orderDetails = requireArguments().get(Keys.MY_ORDER_KEY) as MyOrderModel
        binding.orderItem = orderDetails

        if (orderDetails.orderStatus == "Complete"){
            setOrderItemRecycler(orderDetails.orderItems)
        }else{
            setOrderProcessingRecycler(orderDetails.orderItems)
        }

        binding.btnTracking.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(Keys.MY_ORDER_KEY,orderDetails)
            (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.orderTrackingBottomSheetFragment,bundle)
        }
    }

    private fun setOrderProcessingRecycler(orderItems: ArrayList<MyOrderItemModel>){
        binding.rcvOrderItems.layoutManager = LinearLayoutManager(context)
        binding.rcvOrderItems.adapter = myOrderProcessingItemAdapter
        myOrderProcessingItemAdapter.submitData(orderItems)
    }

    private fun setOrderItemRecycler(orderItems: ArrayList<MyOrderItemModel>) {
        binding.rcvOrderItems.layoutManager = LinearLayoutManager(context)
        binding.rcvOrderItems.adapter = myOrderItemParentAdapter
        myOrderItemParentAdapter.submitData(orderItems)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
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
         * @return A new instance of fragment MyOrderDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyOrderDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setOnOrderItemClick(myOrderItemModel: MyOrderItemModel) {

    }
}