package com.example.uidemo.ui.bottomsheet

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.uidemo.R
import com.example.uidemo.databinding.BottomsheetDialogBookYourTicketBinding
import com.example.uidemo.model.EventAndActivitiesModel
import com.example.uidemo.utils.FakeData
import com.example.uidemo.utils.Keys
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BookMyTicketBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding : BottomsheetDialogBookYourTicketBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetDialogBookYourTicketBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val event = requireArguments().get(Keys.EVENT_AND_ACTIVITIES_KEY) as EventAndActivitiesModel

        val adapter1 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line, FakeData.FakeDateAndTime)
        binding.etSelectDate.setAdapter(adapter1)

        val adapter2 = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,FakeData.FakeDateAndTime)
        binding.etSelectTime.setAdapter(adapter2)

        binding.npAdult.valueText!!.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() != "0"){
                    binding.layoutTicketAdultQuantity.setBackgroundResource(R.drawable.drawable_book_ticket_quantity)
                    binding.tvAdultLabel.setTextColor(resources.getColor(R.color.teal_500,null))
                    setTextViewDrawableColor(binding.tvAdultLabel,R.color.teal_500)
                    binding.npAdult.setBackgroundResource(R.drawable.drawable_book_ticket_number_picker)
                }else{
                    binding.layoutTicketAdultQuantity.setBackgroundResource(R.drawable.drawable_corner5_stroke1_gray)
                    binding.tvAdultLabel.setTextColor(resources.getColor(R.color.black,null))
                    setTextViewDrawableColor(binding.tvAdultLabel,R.color.black)
                    binding.npAdult.setBackgroundResource(R.drawable.corner_gray_15)
                }
            }
        })

        binding.npChild.valueText!!.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            @RequiresApi(Build.VERSION_CODES.M)
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() != "0"){
                    binding.layoutTicketChildQuantity.setBackgroundResource(R.drawable.drawable_book_ticket_quantity)
                    binding.tvChildLabel.setTextColor(resources.getColor(R.color.teal_500,null))
                    setTextViewDrawableColor(binding.tvChildLabel,R.color.teal_500)
                    binding.npChild.setBackgroundResource(R.drawable.drawable_book_ticket_number_picker)
                }else{
                    binding.layoutTicketChildQuantity.setBackgroundResource(R.drawable.drawable_corner5_stroke1_gray)
                    binding.tvChildLabel.setTextColor(resources.getColor(R.color.black,null))
                    setTextViewDrawableColor(binding.tvChildLabel,R.color.black)
                    binding.npChild.setBackgroundResource(R.drawable.corner_gray_15)
                }

            }
        })

        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setTextViewDrawableColor(textView: TextView, color: Int) {
        for (drawable in textView.compoundDrawables) {
            if (drawable != null) {
                drawable.colorFilter =
                    PorterDuffColorFilter(
                        ContextCompat.getColor(textView.context, color),
                        PorterDuff.Mode.SRC_IN
                    )
            }
        }
    }
}