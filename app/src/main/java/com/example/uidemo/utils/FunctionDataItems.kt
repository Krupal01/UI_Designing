package com.example.uidemo.utils

import com.example.uidemo.model.AccountFunctionModel
import com.example.uidemo.R

class FunctionDataItems {
    companion object{
        val FunctionData : ArrayList<AccountFunctionModel> = arrayListOf(
            AccountFunctionModel("Personal Information", R.drawable.account_icon),
            AccountFunctionModel("Loyalty Programme", R.drawable.icon_trophy),
            AccountFunctionModel("Address Book", R.drawable.ic_baseline_location_on_24),
            AccountFunctionModel("Saved Cards", R.drawable.ic_baseline_credit_card_24),
            AccountFunctionModel("My Reviews", R.drawable.ic_baseline_rate_review_24),
            AccountFunctionModel("My Returns", R.drawable.ic_baseline_assignment_return_24),
            AccountFunctionModel("Services", R.drawable.ic_baseline_construction_24),
            AccountFunctionModel("Live Support", R.drawable.ic_baseline_headset_mic_24),
            AccountFunctionModel("Event & Activities", R.drawable.ic_baseline_event_note_24)
        )
    }
}