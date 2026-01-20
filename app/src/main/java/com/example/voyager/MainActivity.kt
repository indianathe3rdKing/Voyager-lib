package com.example.voyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.voyager.ui.theme.VoyagerTheme

// Each post can declare what screen it should open when clicked.
enum class DestinationType { DETAILS, PROFILE }

// Post includes a destination so each post can route to a different screen.
data class Post(
    val id: Long,
    val title: String,
    val destination: DestinationType = DestinationType.DETAILS
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoyagerTheme {
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Navigator(HomeScreen())

}

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        PostLisScreen().Content()
    }

}

class PostLisScreen : Screen {
    @Composable

    override fun Content() {
        val samplePosts = listOf(
            Post(1, "First Post", DestinationType.DETAILS),
            Post(2, "Profilee", DestinationType.PROFILE)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            for (post in samplePosts) {
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

data class PostDetailsScreen(val postId: Long) : Screen {
    @Composable
    override fun Content() {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Surface(color = MaterialTheme.colorScheme.background) {
                Text(
                    "Post Details Screen",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }
    }


}

data class ProfileScreen(val postId: Long) : Screen {
    @Composable
    override fun Content() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            Arrangement.Center,
            Alignment.CenterVertically
        ) {
            Surface(color = MaterialTheme.colorScheme.background) {
                Text(
                    "Profile Screen",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }

}

data class MenuScreen(val postId: Long) : Screen {
    @Composable
    override fun Content() {
        Profile(ProfileDecscription("Ed", "Developer"))
    }

}

data class ProfileDecscription(val profileName: String, val profileDescription: String)

@Composable
fun Profile(profile: ProfileDecscription) {
    val navigator = LocalNavigator.currentOrThrow

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(30.dp, 16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RectangleShape).padding(6.dp)
                ,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.menu_100), contentDescription = "Menu icoon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(
                            shape = CircleShape,
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.author),
                        contentDescription = "profile picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        profile.profileName,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        profile.profileDescription,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(0.86f)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.onSurface.copy(0.68f))
        ) {
        Spacer(modifier = Modifier.height(0.5.dp))}



    }
}


