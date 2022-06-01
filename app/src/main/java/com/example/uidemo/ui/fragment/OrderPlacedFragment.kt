package com.example.uidemo.ui.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.uidemo.R
import com.example.uidemo.databinding.FragmentOrderPlacedBinding
import com.example.uidemo.model.MyOrderModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderPlacedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderPlacedFragment : Fragment() {
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

    private lateinit var binding : FragmentOrderPlacedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentOrderPlacedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderItem = requireArguments().get(Keys.MY_ORDER_KEY) as MyOrderModel
        binding.orderItem = orderItem

        setVideoView()


    }

    private fun setVideoView(){
        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.demo1

        binding.videoView.setVideoURI(Uri.parse(videoPath))
        binding.btnPlayPause.setOnClickListener {
            if (binding.videoView.isPlaying){
                binding.btnPlayPause.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
                binding.videoView.pause()
            }else{
                binding.btnPlayPause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24)
                binding.videoView.start()
            }
        }

        binding.videoView.setOnCompletionListener {
            it.seekTo(0)
            binding.btnPlayPause.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
        }

        binding.btnMyOrders.setOnClickListener {
            val arg = Bundle()
            arg.putInt(Keys.DESTINATION_KEY,R.id.shoppingCart2PreOrderFragment)
            (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.cartFragment,arg)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderPlacedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderPlacedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}