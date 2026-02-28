package com.example.voyager.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voyager.models.NavOption

@Composable
fun NavItem(item: NavOption) {
    var clicked by remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { clicked = !clicked },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(painter = painterResource(id = item.icon), contentDescription = item.title)

            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(0.92f)
            )
        }
    }
}

