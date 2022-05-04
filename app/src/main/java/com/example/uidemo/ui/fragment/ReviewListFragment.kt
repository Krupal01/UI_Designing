package com.example.uidemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.R
import com.example.uidemo.adapter.ReviewCardAdapter
import com.example.uidemo.databinding.FragmentReviewListBinding
import com.example.uidemo.model.ReviewModel
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewListFragment : Fragment(), ReviewCardAdapter.viewMoreClickListener {
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

    private lateinit var binding : FragmentReviewListBinding
    private var reviewCardAdapter = ReviewCardAdapter(this)
    private lateinit var reviewcardLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReviewListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reviewcardLayoutManager = LinearLayoutManager(requireContext())
        setReviewCardRecycler()


    }

    private fun setReviewCardRecycler() {
        binding.rcvReviewCard.layoutManager = reviewcardLayoutManager
        binding.rcvReviewCard.adapter = reviewCardAdapter
        reviewCardAdapter.submitData(FakeData.askReviewlIST)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReviewListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReviewListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setOnViewMoreClickListener(reviewModel: ReviewModel) {

        val bundle = Bundle()
        bundle.putSerializable(Keys.REVIEW_MODEL_KEY,reviewModel)
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.reviewDetailsFragment,bundle)
    }
}