package com.example.uidemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.ReviewOrderItemAdapter
import com.example.uidemo.databinding.FragmentReviewOrderBinding
import com.example.uidemo.model.MyOrderModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewOrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewOrderFragment : Fragment() {
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


    private lateinit var binding : FragmentReviewOrderBinding
    private var reviewOrderItemAdapter = ReviewOrderItemAdapter()
    private lateinit var order : MyOrderModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReviewOrderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        order = FakeData.FakeOrders[0]
        binding.orderItem = order
        setReviewOrderRecycler()

        binding.btnPlaceOrder.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(Keys.MY_ORDER_KEY,order)
            (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.orderPlacedFragment,bundle)
        }

    }

    private fun setReviewOrderRecycler(){
        binding.rcvOrderItems.layoutManager = LinearLayoutManager(context)
        binding.rcvOrderItems.adapter = reviewOrderItemAdapter
        reviewOrderItemAdapter.submitData(order.orderItems)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReviewOrderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReviewOrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}