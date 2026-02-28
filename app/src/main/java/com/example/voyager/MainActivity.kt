package com.example.voyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.example.voyager.screens.HomeScreen
import com.example.voyager.ui.theme.VoyagerTheme

/**
 * Main entry point of the Voyager app.
 *
 * File organization:
 * - models/Models.kt - Data classes (Post, ProfileDescription, NavOption, SampleData)
 * - screens/HomeScreen.kt - Entry screen
 * - screens/PostListScreen.kt - List of posts with navigation
 * - screens/PostDetailsScreen.kt - Post details view
 * - screens/ProfileScreen.kt - User profile view
 * - screens/MenuScreen.kt - Sidebar menu with profile, nav options, and upgrade card
 * - components/Profile.kt - Profile header component
 * - components/NavItem.kt - Single navigation item
 * - components/NavOptions.kt - List of navigation options
 * - components/UpgradeCard.kt - Premium upgrade card
 */
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
                        VoyagerApp()
                    }
                }
            }
        }
    }
}

@Composable
fun VoyagerApp() {
    Navigator(HomeScreen())
}
