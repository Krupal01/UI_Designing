package com.example.uidemo.ui.bottomsheet

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.adapter.MyOrderUpdateAdapter
import com.example.uidemo.databinding.BottomsheetDialogOrderTrackingBinding
import com.example.uidemo.model.MyOrderModel
import com.example.uidemo.model.OrderUpdate
import com.example.uidemo.utils.Keys

class OrderTrackingBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomsheetDialogOrderTrackingBinding
    private lateinit var orderUpdateAdapter: MyOrderUpdateAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetDialogOrderTrackingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderDetails = requireArguments().get(Keys.MY_ORDER_KEY) as MyOrderModel
        binding.orderItem = orderDetails
        orderUpdateAdapter = MyOrderUpdateAdapter()
        layoutManager = LinearLayoutManager(context)
        setOrderUpdateRecycler(orderDetails.orderLatestUpdates)

        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    fun setOrderUpdateRecycler(orderLatestUpdates: ArrayList<OrderUpdate>?) {
        binding.rcvUpdates.adapter = orderUpdateAdapter
        binding.rcvUpdates.layoutManager = layoutManager
        binding.rcvUpdates.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        if (orderLatestUpdates != null) {
            orderUpdateAdapter.submitData(orderLatestUpdates)
        }
    }
}