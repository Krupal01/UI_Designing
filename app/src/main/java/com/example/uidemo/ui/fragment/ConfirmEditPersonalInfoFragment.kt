package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uidemo.R
import com.example.uidemo.databinding.FragmentConfirmEditPersonalInfoBinding
import com.example.uidemo.model.UserPersonalInfoModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.Keys
import com.example.uidemo.view.GenericKeyEvent
import com.example.uidemo.view.GenericTextWatcher

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmEditPersonalInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfirmEditPersonalInfoFragment : Fragment() {
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

    private lateinit var binding : FragmentConfirmEditPersonalInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConfirmEditPersonalInfoBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        val userMobile = requireArguments().get(Keys.USER_NUMBER_KEY) as String
        binding.mobileNumber = userMobile

        setOTPEditText()

    }

    private fun setOTPEditText(){
        binding.otpEt1.addTextChangedListener(GenericTextWatcher(binding.otpEt1,  binding.otpEt2))
        binding.otpEt2.addTextChangedListener(GenericTextWatcher( binding.otpEt2, binding.otpEt3))
        binding.otpEt3.addTextChangedListener(GenericTextWatcher(binding.otpEt3, binding.otpEt4))
        binding.otpEt4.addTextChangedListener(GenericTextWatcher(binding.otpEt4, null))

        binding.otpEt1.setOnKeyListener(GenericKeyEvent(binding.otpEt1, null))
        binding.otpEt2.setOnKeyListener(GenericKeyEvent(binding.otpEt2, binding.otpEt1))
        binding.otpEt3.setOnKeyListener(GenericKeyEvent(binding.otpEt3, binding.otpEt2))
        binding.otpEt4.setOnKeyListener(GenericKeyEvent(binding.otpEt4,binding.otpEt3))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
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
         * @return A new instance of fragment ConfirmEditPersonalInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConfirmEditPersonalInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}