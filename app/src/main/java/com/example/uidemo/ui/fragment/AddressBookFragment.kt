package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.AltrernateAddresAdapter
import com.example.uidemo.adapter.DefaultAddressCardAdapter
import com.example.uidemo.databinding.FragmentAddressBookBinding
import com.example.uidemo.model.AddressCardModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddressBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddressBookFragment : Fragment(), AltrernateAddresAdapter.AlternateItemClick,
    DefaultAddressCardAdapter.DefaultItemClick {
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

    private lateinit var binding : FragmentAddressBookBinding
    private val alternateAddressAdapter = AltrernateAddresAdapter(this)
    private val defaultAddressCardAdapter = DefaultAddressCardAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddressBookBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        setDefaultAddressRecycler()
        setAlternateAddressRecycler()

    }

    private fun setAlternateAddressRecycler(){
        binding.rcvAlternateAddress.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvAlternateAddress.adapter = alternateAddressAdapter
        alternateAddressAdapter.submitData(FakeData.alternateAddress)

    }

    private fun setDefaultAddressRecycler(){
        binding.rcvDefaultAddress.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvDefaultAddress.adapter = defaultAddressCardAdapter
        defaultAddressCardAdapter.submitData(FakeData.defaultAddress)
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
         * @return A new instance of fragment AddressBookFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddressBookFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onAlternateAddressItemClick(addressCardModel: AddressCardModel) {
        TODO("Not yet implemented")
    }

    override fun onAlternateAddressMenuClick(addressCardModel: AddressCardModel, view: View) {
        val popupMenu = PopupMenu(requireContext(),view)
        popupMenu.inflate(R.menu.menu_address_item)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.setAsDefault ->{
                    Toast.makeText(requireContext(),"SetAsDefault", Toast.LENGTH_LONG).show()
                }
                R.id.editAddress ->{

                }
            }
            false
        }
        popupMenu.show()
    }

    override fun onDefaultAddressItemClick(addressCardModel: AddressCardModel) {
        TODO("Not yet implemented")
    }

    override fun onDefaultAddressEditClick(addressCardModel: AddressCardModel) {
        val bundle = Bundle()
        bundle.putString(Keys.ADDRESS_TITLE_KEY, Keys.EDIT_ADDRESS_KEY)
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.editAddressFragment,bundle)
    }
}