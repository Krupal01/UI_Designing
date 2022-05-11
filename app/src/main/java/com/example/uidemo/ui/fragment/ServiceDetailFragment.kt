package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.adapter.CommentsAdapter
import com.example.uidemo.databinding.FragmentServiceDetailBinding
import com.example.uidemo.model.ServiceItemModel
import com.example.uidemo.model.ServiceItemUpdates
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ServiceDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ServiceDetailFragment : Fragment() {
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

    private lateinit var binding : FragmentServiceDetailBinding
    private lateinit var layoutManager:LinearLayoutManager
    private var adapter = CommentsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceDetailBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        var serviceItem = requireArguments().get(Keys.SERVICE_MODEL_KEY) as ServiceItemModel
        binding.serviceItem = serviceItem
        serviceItem.itemUpdates?.let { setCommentRecycler(it)}
    }

    private fun setCommentRecycler(itemUpdates: ArrayList<ServiceItemUpdates>) {
        layoutManager = LinearLayoutManager(context)
        binding.rcvComment.layoutManager = layoutManager
        binding.rcvComment.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        binding.rcvComment.adapter = adapter
        adapter.submitData(itemUpdates)
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
         * @return A new instance of fragment ServiceDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServiceDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}