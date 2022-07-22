package ru.khomichenko.myapplication.main_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.khomichenko.myapplication.R
import ru.khomichenko.myapplication.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MainFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadPhotos()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.networkState.collect { loadingState ->
                    when(loadingState) {
                        is MainFragmentState.Loading -> {
                            binding.progressCircular.visibility = View.VISIBLE
                        }
                        is MainFragmentState.Success -> {
                            binding.progressCircular.visibility = View.INVISIBLE
                        }
                        is MainFragmentState.Error -> {
                            binding.progressCircular.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        }
    }
}