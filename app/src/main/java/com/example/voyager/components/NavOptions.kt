package com.example.voyager.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.voyager.models.NavOption

@Composable
fun NavOptions(options: List<NavOption>) {
    LazyColumn {
        items(options) { option ->
            NavItem(option)
        }
    }
}

