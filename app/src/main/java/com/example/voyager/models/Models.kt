package com.example.voyager.models

import com.example.voyager.R

enum class DestinationType { DETAILS, PROFILE }

data class Post(
    val id: Long,
    val title: String,
    val destination: DestinationType = DestinationType.DETAILS
)

data class ProfileDescription(val profileName: String, val profileDescription: String)

data class NavOption(val icon: Int, val title: String)

object SampleData {
    val navOptionsSample = listOf(
        NavOption(R.drawable.dashboard, "Dashboard"),
        NavOption(R.drawable.analytics, "Analytics"),
        NavOption(R.drawable.messages, "Messages"),
        NavOption(R.drawable.leaderboard, "Collections"),
        NavOption(R.drawable.user, "User"),
    )

    val samplePosts = listOf(
        Post(1, "First Post", DestinationType.DETAILS),
        Post(2, "Profilee", DestinationType.PROFILE)
    )
}

