package com.android.pacenow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.pacenow.base.BaseFragment
import com.android.pacenow.databinding.FragmentCountryBinding
import com.android.pacenow.adapter.CountryAdapter
import com.android.pacenow.viewmodel.CountryFragmentViewModel

class CountryFragment : BaseFragment() {

    private var _binding: FragmentCountryBinding? = null

    private val binding get() = _binding!!

    private val countryFragmentViewModel : CountryFragmentViewModel by viewModels()
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryAdapter = CountryAdapter(arrayListOf())
        binding.countryRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.countryRecyclerView.adapter = countryAdapter

        initObserver()

    }

    private fun initObserver() {
        countryFragmentViewModel.getCountryResponse().observe(viewLifecycleOwner,{
            respose ->
                if (respose.country.isNotEmpty()) {
                    countryAdapter.setItem(respose.country)
                }
            binding.progressBar.visibility = View.INVISIBLE
        })
        countryFragmentViewModel.getCountryApiErrorResponse().observe(viewLifecycleOwner,{
            binding.progressBar.visibility = View.INVISIBLE
        })
        binding.progressBar.visibility = View.VISIBLE
        countryFragmentViewModel.getCountryList()
    }


}