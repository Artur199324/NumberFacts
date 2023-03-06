package com.hos.mager.numberfacts.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hos.mager.numberfacts.data.MathFactRepositoryImpl
import com.hos.mager.numberfacts.data.NumbersApiRepositoryImpl
import com.hos.mager.numberfacts.data.NumbersApiService
import com.hos.mager.numberfacts.data.room.MathFact
import com.hos.mager.numberfacts.databinding.ActivityMainBinding
import com.hos.mager.numberfacts.domain.userCase.GetMathFactUseCase
import com.hos.mager.numberfacts.domain.userCase.MathFactUserCase
import com.hos.mager.numberfacts.presentation.adapter.MathFactAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), MathFactAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MathFactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewModelProvider(this)[MathFactViewModel::class.java].also { viewModel = it }
        binding.rreccss.layoutManager = LinearLayoutManager(this)
        val numbersApiService = NumbersApiService()
        val numbersApiRepository = NumbersApiRepositoryImpl(numbersApiService)
        val getMathFactUseCase = GetMathFactUseCase(numbersApiRepository)
        val mathFactRepository = MathFactRepositoryImpl()
        val mathFactUseCase = MathFactUserCase(mathFactRepository)
        appdate(mathFactUseCase)
        binding.button.setOnClickListener {
            if (binding.editTextNumber2.text.isNotEmpty()) {
                lifecycleScope.launch {
                    val nu = binding.editTextNumber2.text.toString().toInt()
                    binding.textView.text = viewModel.getMathFact(nu, getMathFactUseCase)
                    binding.editTextNumber2.setText("")
                    viewModel.save(binding.textView.text.toString(), mathFactUseCase)
                    Log.d("weq", viewModel.getSave(mathFactUseCase).size.toString())
                    cancel()
                    appdate(mathFactUseCase)
                }

            } else {
                Toast.makeText(this, "enter the number", Toast.LENGTH_LONG).show()
            }
        }

        binding.button2.setOnClickListener {
            lifecycleScope.launch {
                binding.textView.text = viewModel.getMathFact(getMathFactUseCase)
                viewModel.save(binding.textView.text.toString(), mathFactUseCase)
                cancel()
                appdate(mathFactUseCase)
            }
        }


    }

    override fun onItemClick(mathFact: MathFact) {
        val intent = Intent(this,MoreActivity::class.java).apply {
            putExtra(packageName,mathFact.fact)
        }
        startActivity(intent)
    }

    private fun appdate(mathFactUserCase: MathFactUserCase) {
        lifecycleScope.launch(Dispatchers.IO) {
            val adapter = MathFactAdapter(
                viewModel.getSave(mathFactUseCase = mathFactUserCase),
                this@MainActivity
            )
            cancel()
            lifecycleScope.launch(Dispatchers.Main) {
                binding.rreccss.adapter = adapter
                cancel()
            }


        }
    }
}