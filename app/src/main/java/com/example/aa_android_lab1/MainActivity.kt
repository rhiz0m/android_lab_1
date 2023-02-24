package com.example.aa_android_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.aa_android_lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding //binding reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //init viewBinding
        setContentView(binding.root)

        val movieSwitch = binding.moviesSwitch
        val tvMovie = binding.movieCardview
        tvMovie.isVisible = false

        movieSwitch.setOnClickListener() {

            tvMovie.isVisible = movieSwitch.isChecked
            tvMovie.isVisible = tvMovie.isVisible
        }

    }

}