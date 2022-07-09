package ru.khomochenko.domain.network.utils

sealed class Response {
    data class Success(val _data: Any?): Response()

    object Error: Response()

    object Loading: Response()
}