package ru.khomochenko.data.network.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import ru.khomochenko.data.network.data_source.PhotoApi
import ru.khomochenko.data.network.mapper.toEntity
import ru.khomochenko.domain.network.repository.PhotosNetworkRepository
import ru.khomochenko.domain.network.utils.Response
import java.io.IOException
import javax.inject.Inject

class PhotosNetworkRepositoryImpl @Inject constructor(
    private val api: PhotoApi
) : PhotosNetworkRepository {

    override fun getPhotos(): Flow<Response> = flow {
        emit(Response.Loading)
        try {
            val body = api.getOnePagePhotos().map { it.toEntity() }
            emit(Response.Success(body))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Response.Error)
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Response.Error)
        }
    }.flowOn(Dispatchers.IO)
}