package com.example.uidemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.CheckOutAddressAdapter
import com.example.uidemo.databinding.FragmentShippingAndBillingBinding
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShippingAndBillingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShippingAndBillingFragment : Fragment() {
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

    private lateinit var binding : FragmentShippingAndBillingBinding
    private var checkOutAddressAdapter = CheckOutAddressAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShippingAndBillingBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAddressRecycler()

        binding.btnAddNewAddress.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Keys.ADDRESS_TITLE_KEY,Keys.NEW_ADDRESS_KEY)
            (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.editAddressFragment,bundle)
        }

    }

    private fun setAddressRecycler(){
        binding.rcvSelectShippingAdd.layoutManager = LinearLayoutManager(context)
        binding.rcvSelectShippingAdd.adapter = checkOutAddressAdapter
        checkOutAddressAdapter.submitData(FakeData.fakeAddress)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShippingAndBillingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShippingAndBillingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}