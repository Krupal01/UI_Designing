package com.example.uidemo.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uidemo.Model.CategoryModel
import com.example.uidemo.R
import com.example.uidemo.adapter.CategoryAdapter
import com.example.uidemo.adapter.ItemsAdapter
import com.example.uidemo.databinding.FragmentCategoriesBinding
import com.example.uidemo.ui.activity.MainActivity
import com.example.uidemo.utils.FakeData


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment(), CategoryAdapter.CategoryClickListener {
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

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var itemsAdapter: ItemsAdapter
    private lateinit var textCartItemCount : TextView
    private lateinit var catlayoutManager: LinearLayoutManager
    private val fakeData = FakeData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setToolbar(binding.toolbar)
        (activity as AppCompatActivity).title = ""
        categoryAdapter = CategoryAdapter(this)
        itemsAdapter = ItemsAdapter()

        setCategoryRecycler()
        setItemRecycler()

        binding.fabScrDown.setOnClickListener {
            val totalItemCount: Int = binding.rcvCategories.adapter?.itemCount ?: 0
            if (totalItemCount<=0) return@setOnClickListener
            val lastPosition : Int = catlayoutManager.findLastVisibleItemPosition()
            if (lastPosition<totalItemCount){
                catlayoutManager.smoothScrollToPosition(binding.rcvCategories,null,lastPosition+1)
            }
        }

    }

    private fun setCategoryRecycler() {
        catlayoutManager = LinearLayoutManager(context)
        binding.rcvCategories.layoutManager = catlayoutManager
        binding.rcvCategories.adapter = categoryAdapter
        categoryAdapter.submitData(fakeData.fakeCategories(requireContext(),"Category"))

    }

    private fun setItemRecycler(){
        val gridLayoutManager = GridLayoutManager(context,2)
        binding.rcvItems.layoutManager = gridLayoutManager
        binding.rcvItems.adapter = itemsAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.category_menu,menu)

        val menuItem : MenuItem = menu.findItem(R.id.category_notifications)
        val actionView : View = menuItem.actionView
        textCartItemCount = actionView.findViewById(R.id.cart_badge) as TextView

        setupBadge(2)

    }

    fun setupBadge(i: Int){
        if (i == 0) {
            if (textCartItemCount.visibility != View.GONE) {
                textCartItemCount.visibility = View.GONE;
            }
        } else {
            textCartItemCount.text = i.toString()
            if (textCartItemCount.visibility != View.VISIBLE) {
                textCartItemCount.visibility = View.VISIBLE;
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setOnCategoryClickLister(categoryModel: CategoryModel) {
        binding.tvCategoryTitle.text = categoryModel.title
        itemsAdapter.submitData(fakeData.fakeItems(requireContext(),categoryModel.title))
    }
}