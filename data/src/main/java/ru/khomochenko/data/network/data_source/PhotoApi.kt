package ru.khomochenko.data.network.data_source

import retrofit2.http.GET
import ru.khomochenko.data.network.dto.PhotoResponseDTO

interface PhotoApi {

    @GET("/photos")
    suspend fun getOnePagePhotos() : List<PhotoResponseDTO>
}