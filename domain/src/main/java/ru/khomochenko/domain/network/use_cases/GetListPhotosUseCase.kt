package ru.khomochenko.domain.network.use_cases

import kotlinx.coroutines.flow.Flow
import ru.khomochenko.domain.network.repository.PhotosNetworkRepository
import ru.khomochenko.domain.network.utils.Response
import javax.inject.Inject

class GetListPhotosUseCase @Inject constructor(
    private val repository: PhotosNetworkRepository
) {

    operator fun invoke() : Flow<Response> =
        repository.getPhotos()
}