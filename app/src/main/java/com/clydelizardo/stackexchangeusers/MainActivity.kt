package com.clydelizardo.stackexchangeusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.clydelizardo.stackexchangeusers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var contentView: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(contentView.toolbar)
    }
}