package com.prashant.clickretina.model
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val user: UserData
)

@Serializable
data class UserData(
    val username: String,
    val name: String,
    val location: Location,
    val avatar: String,
    val social: Social,
    val statistics: Statistics
)

@Serializable
data class Location(
    val city: String,
    val country: String
)

@Serializable
data class Social(
    val website: String,
    val profiles: List<SocialProfile>
)

@Serializable
data class SocialProfile(
    val platform: String,
    val url: String
)

@Serializable
data class Statistics(
    val followers: Int,
    val following: Int,
    val activity: Activity
)

@Serializable
data class Activity(
    val shots: Int,
    val collections: Int
)