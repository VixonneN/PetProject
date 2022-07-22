package ru.khomichenko.myapplication.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import ru.khomichenko.myapplication.R
import ru.khomichenko.myapplication.databinding.ActivityMainBinding
import ru.khomichenko.myapplication.main_fragment.MainFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit(allowStateLoss = true) {
            replace(R.id.container, MainFragment())
        }
    }
}