package com.android.pacenow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.pacenow.R
import com.android.pacenow.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}