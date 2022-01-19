package com.android.pacenow.view.dashboard.activity

import android.os.Bundle
import com.android.pacenow.R
import com.android.pacenow.base.BaseActivity
import com.android.pacenow.databinding.DashboardActivityBinding
import com.android.pacenow.view.dashboard.adapter.ViewPagerAdapter
import com.android.pacenow.view.dashboard.fragment.CountryFragment
import com.android.pacenow.view.dashboard.fragment.LanguageFragment
import com.android.pacenow.view.dashboard.fragment.Tab3Fragment

class DashboardActivity : BaseActivity() {

    private lateinit var binding: DashboardActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CountryFragment(), getString(R.string.tab_1))
        adapter.addFragment(LanguageFragment(), getString(R.string.tab_2))
        adapter.addFragment(Tab3Fragment(), getString(R.string.tab_3))
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }

}