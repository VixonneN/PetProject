package ru.khomochenko.data.network.dto

import com.google.gson.annotations.SerializedName

data class PhotoResponseDTO(
    val id: String,
    val urls: UrlsDTO,
    val user: UserDTO,
    val likes: Int
)

data class UrlsDTO(
    val thumb: String
)

data class UserDTO(
    val id: String,
    val username: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String?,
    val bio: String,
    @SerializedName("profile_image")
    val profileImage: ProfileImageDTO,
    @SerializedName("instagram_username")
    val instagramUserName: String
)

data class ProfileImageDTO(
    val large: String
)