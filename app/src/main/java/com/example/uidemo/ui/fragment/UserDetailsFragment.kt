package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.AccountFunctionAdapter
import com.example.uidemo.databinding.FragmentUserDetailsBinding
import com.example.uidemo.model.AccountFunctionModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FunctionDataItems

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserDetailsFragment : Fragment(), AccountFunctionAdapter.OnFunctionClick {
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

    private lateinit var binding : FragmentUserDetailsBinding
    private lateinit var adapter : AccountFunctionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AccountFunctionAdapter(this)

        setFunctionRecyeler()
        adapter.submitData(FunctionDataItems.FunctionData)

        binding.imgBtnSetting.setOnClickListener {
            Log.i("clik","clicked")
            ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.settingFragment)
        }

        binding.layoutMyTicket.setOnClickListener {
            ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.myTicketFragment)
        }

    }

    private fun setFunctionRecyeler() {
        binding.rcvAccountFunctions.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvAccountFunctions.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setOnFunctionClickListener(accountFunctionModel: AccountFunctionModel) {
        when(accountFunctionModel.name){
            getString(R.string.Personal_Information) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.personalInformationFragment)
            }
            getString(R.string.Loyalty_Programme) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.loyaltyProgrammeFragment)
            }
            getString(R.string.Address_Book) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.addressBookFragment)
            }
            getString(R.string.Saved_Cards) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.savedCardsFragment)
            }
            getString(R.string.My_Reviews) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.myReviewFragment)
            }
            getString(R.string.My_Returns) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.myReturnsFragment)
            }
            getString(R.string.Services) ->{
                ( activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.serviceFragment)
            }
            getString(R.string.Live_Support) ->{

            }
        }
    }
}