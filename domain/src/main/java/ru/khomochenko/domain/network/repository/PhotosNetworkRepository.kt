package ru.khomochenko.domain.network.repository

import kotlinx.coroutines.flow.Flow
import ru.khomochenko.domain.network.utils.Response

interface PhotosNetworkRepository {
    fun getPhotos() : Flow<Response>
}