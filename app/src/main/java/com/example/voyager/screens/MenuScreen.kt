package com.example.voyager.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.voyager.components.NavOptions
import com.example.voyager.components.Profile
import com.example.voyager.components.UpgradeCard
import com.example.voyager.models.ProfileDescription
import com.example.voyager.models.SampleData

data class MenuScreen(val postId: Long) : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 0.dp)
        ) {
            Profile(ProfileDescription("Ed", "Developer"))
            NavOptions(SampleData.navOptionsSample)
            Spacer(modifier = Modifier.height(16.dp))
            UpgradeCard()
        }
    }
}

