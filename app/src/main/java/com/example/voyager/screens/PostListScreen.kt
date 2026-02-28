package com.example.voyager.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.voyager.models.DestinationType
import com.example.voyager.models.Post
import com.example.voyager.models.SampleData

class PostListScreen : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            for (post in SampleData.samplePosts) {
                PostCard(post)
            }
        }
    }

    @Composable
    private fun PostCard(post: Post) {
        val navigator = LocalNavigator.currentOrThrow

        Card {
            Column(modifier = Modifier.padding(8.dp)) {
                // Title -> navigates to PostDetails
                Text(
                    post.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // Navigate to the screen specified by this post's destination
                            when (post.destination) {
                                DestinationType.DETAILS -> navigator.push(PostDetailsScreen(post.id))
                                DestinationType.PROFILE -> navigator.push(MenuScreen(post.id))
                            }
                        }
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                // Secondary action -> navigates to Profile
                Text(
                    "View Profile",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigator.push(ProfileScreen(post.id)) }
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

