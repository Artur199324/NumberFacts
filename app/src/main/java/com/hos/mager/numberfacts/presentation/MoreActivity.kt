package com.hos.mager.numberfacts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hos.mager.numberfacts.databinding.ActivityMoreBinding

class MoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityMoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView3.text = intent.getStringExtra(packageName)
    }
}