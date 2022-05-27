package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uidemo.R
import com.example.uidemo.databinding.FragmentEditAddressBinding
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditAddressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditAddressFragment : Fragment() {
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

   private lateinit var binding: FragmentEditAddressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditAddressBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = requireArguments().getString(Keys.ADDRESS_TITLE_KEY)
        if (title != null) {
            if (title == Keys.EDIT_ADDRESS_KEY){
                binding.tvToolbarTitle.text = resources.getString(R.string.edit_shipping_address)
            }else if (title == Keys.NEW_ADDRESS_KEY){
                binding.tvToolbarTitle.text = resources.getString(R.string.new_shipping_address)
            }
        }
        val adapter1 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,FakeData.zoneNumber)
        binding.etZoneNumber.setAdapter(adapter1)

        val adapter2 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,FakeData.country)
        binding.etCountry.setAdapter(adapter2)

        binding.etZoneNumber.setOnFocusChangeListener { view, b ->
            if(b){
                binding.etZoneNumber.setHint(R.string.search_by_zone_number)
                binding.etZoneNumber.setBackgroundResource(R.drawable.dropdown_search_drawable)
                binding.layoutZoneNumber.setStartIconDrawable(R.drawable.ic_baseline_search_24)
                binding.layoutZoneNumber.setBackgroundResource(R.color.white)
                binding.layoutZoneNumber.setPadding(15,10,15,10)
                binding.layoutZoneNumber.setBackgroundResource(R.drawable.card_number_text_drawable)

            }else{
                binding.etZoneNumber.setHint(R.string.blank)
                binding.etZoneNumber.setBackgroundResource(R.drawable.card_number_text_drawable)
                binding.layoutZoneNumber.setStartIconDrawable(0)
                binding.layoutZoneNumber.setPadding(0,0,0,0)
                binding.layoutZoneNumber.setBackgroundResource(R.drawable.card_number_text_drawable)
            }
        }

        binding.etCountry.setOnFocusChangeListener { view, b ->
            if(b){
                binding.etCountry.setHint(R.string.search_by_country_name)
                binding.etCountry.setBackgroundResource(R.drawable.dropdown_search_drawable)
                binding.layoutCountry.setStartIconDrawable(R.drawable.ic_baseline_search_24)
                binding.layoutCountry.setBackgroundResource(R.color.white)
                binding.layoutCountry.setPadding(15,10,15,10)
                binding.layoutCountry.setBackgroundResource(R.drawable.card_number_text_drawable)

            }else{
                binding.etCountry.setHint(R.string.blank)
                binding.etCountry.setBackgroundResource(R.drawable.card_number_text_drawable)
                binding.layoutCountry.setStartIconDrawable(0)
                binding.layoutCountry.setPadding(0,0,0,0)
                binding.layoutCountry.setBackgroundResource(R.drawable.card_number_text_drawable)
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
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
         * @return A new instance of fragment EditAddressFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditAddressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}