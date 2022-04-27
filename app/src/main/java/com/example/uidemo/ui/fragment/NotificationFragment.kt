package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.CartNotificationScrAdapter
import com.example.uidemo.adapter.PastNotificationAdapter
import com.example.uidemo.databinding.CustomToolbarBinding
import com.example.uidemo.databinding.FragmentNotificationBinding
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationFragment : Fragment() {
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

    private lateinit var binding : FragmentNotificationBinding
    private lateinit var cartNotificationLayoutManager: LinearLayoutManager
    private var cartNotificationScrAdapter = CartNotificationScrAdapter()
    private var pastNotificationAdapter = PastNotificationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater , container , false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        cartNotificationLayoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        setCartRecycler()
        setPastNotificationRecycler()



    }

    private fun setPastNotificationRecycler() {
        binding.rcvPastNot.layoutManager = LinearLayoutManager(requireContext())
        binding.rcvPastNot.adapter = pastNotificationAdapter
        pastNotificationAdapter.submitData(FakeData.pastNotificationData)
    }

    private fun setCartRecycler() {
        binding.tvNotRcvCard3.layoutManager = cartNotificationLayoutManager
        binding.tvNotRcvCard3.adapter = cartNotificationScrAdapter
        cartNotificationScrAdapter.submitData(FakeData().fakeItems(requireContext(),"Books"))
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
         * @return A new instance of fragment NotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}