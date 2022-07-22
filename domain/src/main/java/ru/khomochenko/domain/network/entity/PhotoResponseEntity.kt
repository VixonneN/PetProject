package ru.khomochenko.domain.network.entity

data class PhotoResponseEntity(
    val id: String,
    val urls: UrlsEntity,
    val user: UserEntity,
    val likes: Int
)

data class UrlsEntity(
    val full: String,
    val thumb: String
)

data class UserEntity(
    val id: String,
    val username: String,
    val firstName: String,
    val lastName: String?,
    val bio: String?,
    val profileImage: ProfileImageEntity,
    val instagramUserName: String?
)

data class ProfileImageEntity(
    val large: String
)