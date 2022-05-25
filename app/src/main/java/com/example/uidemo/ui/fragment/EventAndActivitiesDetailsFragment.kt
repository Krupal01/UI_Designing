package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.EventSpeakerAdapter
import com.example.uidemo.databinding.FragmentEventAndActivitiesDetailsBinding
import com.example.uidemo.model.EventAndActivitiesModel
import com.example.uidemo.model.EventSpeaker
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.Keys
import com.google.android.gms.maps.SupportMapFragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventAndActivitiesDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventAndActivitiesDetailsFragment : Fragment() {
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

    private lateinit var binding : FragmentEventAndActivitiesDetailsBinding
    private var reviewExpanded : Boolean = false
    private var speakerAdapter = EventSpeakerAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEventAndActivitiesDetailsBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val event = requireArguments().get(Keys.EVENT_AND_ACTIVITIES_KEY) as EventAndActivitiesModel
        setInitView(event)

        (activity as MainActivity).setToolbar(binding.Notificationtoolbar,false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.btnExpand.setOnClickListener {
            if (reviewExpanded){
                reviewExpanded = false
                binding.btnExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                binding.ChildLayoutCustomerReview.visibility = View.GONE
            }else{
                reviewExpanded = true
                binding.btnExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                binding.ChildLayoutCustomerReview.visibility = View.VISIBLE
            }
        }



    }

    private fun setInitView(event: EventAndActivitiesModel) {
        binding.event = event
        if(event.EventCustomerReviews != null){
            reviewExpanded = false
            binding.btnExpand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            binding.ChildLayoutCustomerReview.visibility = View.GONE
        }else{
            binding.LayoutCustomerReview.visibility = View.GONE
        }
        if (event.EventLocation != null){
            binding.LayoutMap.visibility = View.VISIBLE
        }else{
            binding.LayoutMap.visibility = View.GONE
        }

        setSpeackerRecycler(event.EventSpeaker)
        setMap()

    }

    private fun setSpeackerRecycler(eventSpeaker: ArrayList<EventSpeaker>) {
        binding.rcvSpeakers.layoutManager = LinearLayoutManager(context)
        binding.rcvSpeakers.adapter = speakerAdapter
        speakerAdapter.submitDate(eventSpeaker)
    }

    private fun setMap(){
        val supportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment

        supportMapFragment.getMapAsync { googleMap ->
            googleMap.setOnMapClickListener {
//                val markerOptions = MarkerOptions()
//                markerOptions.position(latLng)
//                markerOptions.title(latLng.latitude.toString() + " : " + latLng.longitude)
//                googleMap.clear()
//                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
//                googleMap.addMarker(markerOptions)
            }
        }
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
         * @return A new instance of fragment EventAndActivitiesDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventAndActivitiesDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}