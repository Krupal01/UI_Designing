package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.TransactionAdapter
import com.example.uidemo.adapter.WishListAdapter
import com.example.uidemo.databinding.FragmentLoyaltyProgrammeBinding
import com.example.uidemo.model.TransactionModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoyaltyProgrammeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoyaltyProgrammeFragment : Fragment() {
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

    private lateinit var binding : FragmentLoyaltyProgrammeBinding
    private var recentListAdapter= WishListAdapter()
    private lateinit var recentListlayoutManager: LinearLayoutManager
    private lateinit var transactionLauout : LinearLayoutManager
    private var transactionAdapter = TransactionAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoyaltyProgrammeBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        recentListlayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        setLoyaltyRecentRecycler()
        recentListAdapter.submitData(FakeData.data)

        transactionLauout = LinearLayoutManager(requireContext())
        setTransactionRcv()

    }

    private fun setTransactionRcv() {
        binding.rcvTransactions.layoutManager = transactionLauout
        binding.rcvTransactions.adapter = transactionAdapter
        transactionAdapter.submitData(ArrayList(FakeData.transactions.subList(0,2)))
    }

    private fun setLoyaltyRecentRecycler() {
        binding.rcvLoyaltyRecentList.layoutManager = recentListlayoutManager
        binding.rcvLoyaltyRecentList.adapter = recentListAdapter
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
         * @return A new instance of fragment LoyaltyProgrammeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoyaltyProgrammeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}