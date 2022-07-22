package ru.khomochenko.data.network.mapper

import ru.khomochenko.data.network.dto.PhotoResponseDTO
import ru.khomochenko.data.network.dto.ProfileImageDTO
import ru.khomochenko.data.network.dto.UrlsDTO
import ru.khomochenko.data.network.dto.UserDTO
import ru.khomochenko.domain.network.entity.PhotoResponseEntity
import ru.khomochenko.domain.network.entity.ProfileImageEntity
import ru.khomochenko.domain.network.entity.UrlsEntity
import ru.khomochenko.domain.network.entity.UserEntity

fun PhotoResponseDTO.toEntity(): PhotoResponseEntity =
    PhotoResponseEntity(id, urls.toEntity(), user.toEntity(), likes)

fun UrlsDTO.toEntity(): UrlsEntity =
    UrlsEntity(full, thumb)

fun UserDTO.toEntity(): UserEntity =
    UserEntity(id, username, firstName, lastName, bio, profileImage.toEntity(), instagramUserName)

fun ProfileImageDTO.toEntity() : ProfileImageEntity =
    ProfileImageEntity(large)