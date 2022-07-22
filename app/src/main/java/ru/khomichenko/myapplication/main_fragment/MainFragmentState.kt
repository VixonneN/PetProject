package ru.khomichenko.myapplication.main_fragment

sealed class MainFragmentState {
    object Loading: MainFragmentState()
    object Success: MainFragmentState()
    object Error: MainFragmentState()
}
