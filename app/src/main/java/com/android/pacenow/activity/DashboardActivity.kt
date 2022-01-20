package com.android.pacenow.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.android.pacenow.R
import com.android.pacenow.base.BaseActivity
import com.android.pacenow.databinding.DashboardActivityBinding
import com.android.pacenow.adapter.ViewPagerAdapter
import com.android.pacenow.fragment.CountryFragment
import com.android.pacenow.fragment.LanguageFragment
import com.android.pacenow.fragment.Tab3Fragment
import java.util.*


class DashboardActivity : BaseActivity() {

    private lateinit var binding: DashboardActivityBinding
    private lateinit var locale: Locale

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar);
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CountryFragment(), getString(R.string.tab_1))
        adapter.addFragment(LanguageFragment(), getString(R.string.tab_2))
        adapter.addFragment(Tab3Fragment(), getString(R.string.tab_3))
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.right_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                preferenceHelper.clearPrefs()
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            }
        }
        return true
    }

     fun setLocale(localeName: String) {
        if (localeName != langPrefHelper.getCountryCode()) {
            langPrefHelper.setCountryCode(localeName)
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this,
                DashboardActivity::class.java
            )
            startActivity(refresh)
            finish()
            binding.viewPager.currentItem = 2
        } else {
            Toast.makeText(
                this, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
        }
    }


}