package com.debasish.sampleweatherapp.presentation.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debasish.sampleweatherapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.sheet_city_add.*
import kotlinx.android.synthetic.main.sheet_city_add.view.*

class AddCItySheet : BottomSheetDialogFragment() {

var saveCity : ((String?)->Unit) ?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sheet_city_add, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.mbAdd.setOnClickListener {
            saveCity?.invoke(view.tieCityName.text.toString())
        }

    }
}