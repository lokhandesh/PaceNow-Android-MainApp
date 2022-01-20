package com.android.pacenow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.android.pacenow.R
import com.android.pacenow.base.BaseFragment
import com.android.pacenow.databinding.FragmentLanguageBinding
import com.android.pacenow.activity.DashboardActivity

class LanguageFragment : BaseFragment() {

    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<String>()
        list.add(getString(R.string.select_lang))
        list.add(getString(R.string.english))
        list.add(getString(R.string.russian))

        val adapter = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> {
                    }
                    1 -> {
                        (activity as DashboardActivity?)?.setLocale("en")
                    }
                    2 -> {
                        (activity as DashboardActivity?)?.setLocale("ru")
                    }

                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


    }


}