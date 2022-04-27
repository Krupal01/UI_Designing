package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.DebitCardAdapter
import com.example.uidemo.databinding.FragmentCardSettingBinding
import com.example.uidemo.model.DebitCardModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CardSettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardSettingFragment : Fragment(), DebitCardAdapter.OnCardClick {
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

    private lateinit var binding : FragmentCardSettingBinding
    private lateinit var cardLayoutManager: LinearLayoutManager
    private var debitCardAdapter=  DebitCardAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCardSettingBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        cardLayoutManager = LinearLayoutManager(requireContext())
        setAlternateCards()


//        binding.btnAlternateCardMenu.setOnClickListener {
//            val popupMenu = PopupMenu(requireContext(),it)
//            popupMenu.inflate(R.menu.menu_card_item)
//            popupMenu.setOnMenuItemClickListener { item ->
//                when (item.itemId) {
//                    R.id.SetAsDefault ->{
//                        Toast.makeText(requireContext(),"SetAsDefault",Toast.LENGTH_LONG).show()
//                    }
//                    R.id.Remove ->{
//                        Toast.makeText(requireContext(),"Remove",Toast.LENGTH_LONG).show()
//                    }
//                }
//                false
//            }
//            popupMenu.show()
//        }

        binding.btnDefaultCardMenu.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(),it)
            popupMenu.inflate(R.menu.menu_card_item)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.SetAsDefault ->{
                        Toast.makeText(requireContext(),"SetAsDefault",Toast.LENGTH_LONG).show()
                    }
                    R.id.Remove ->{
                        Toast.makeText(requireContext(),"Remove",Toast.LENGTH_LONG).show()
                    }
                }
                false
            }
            popupMenu.show()
        }

    }

    fun setAlternateCards(){
        binding.rcvAlternateCards.layoutManager = cardLayoutManager
        binding.rcvAlternateCards.adapter = debitCardAdapter
        debitCardAdapter.submitData(FakeData.cards)
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
         * @return A new instance of fragment CardSettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardSettingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setOnCardClickListener(debitCard: DebitCardModel, view: View) {
        val popupMenu = PopupMenu(requireContext(),view)
        popupMenu.inflate(R.menu.menu_card_item)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.SetAsDefault ->{
                    Toast.makeText(requireContext(),"SetAsDefault",Toast.LENGTH_LONG).show()
                }
                R.id.Remove ->{
                    Toast.makeText(requireContext(),"Remove",Toast.LENGTH_LONG).show()
                }
            }
            false
        }
        popupMenu.show()
    }
}