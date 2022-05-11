package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.ServiceItemAdapter
import com.example.uidemo.databinding.FragmentServiceBinding
import com.example.uidemo.model.ServiceItemModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ServiceFragment : Fragment(), ServiceItemAdapter.OnServiceItemClick {
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

    private lateinit var binding : FragmentServiceBinding
    private var serviceItemsAdapter = ServiceItemAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentServiceBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)


        setServiceRecycler()

    }

    private fun setServiceRecycler(){
        binding.rcvServiceItem.layoutManager = LinearLayoutManager(context)
        binding.rcvServiceItem.adapter = serviceItemsAdapter
        serviceItemsAdapter.submitData(FakeData.serviceItems)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.notification_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            findNavController().popBackStack()
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
         * @return A new instance of fragment ServiceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServiceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setOnSeeDetailsClickListener(serviceItemModel: ServiceItemModel) {
        val bundle = Bundle()
        bundle.putSerializable(Keys.SERVICE_MODEL_KEY,serviceItemModel)
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.serviceDetailFragment,bundle)
    }
}