package com.example.uidemo.ui.bottomsheet

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.uidemo.databinding.BottomsheetDialogUseRewardPointBinding


/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    UseRewardPointBottomSheetFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class UseRewardPointBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomsheetDialogUseRewardPointBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = BottomsheetDialogUseRewardPointBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}