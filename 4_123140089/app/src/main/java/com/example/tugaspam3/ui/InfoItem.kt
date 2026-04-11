package com.example.tugaspam3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun InfoItem(icon: ImageVector, title: String, value: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {

        Icon(icon, contentDescription = title)

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(title)
            Text(value)
        }
    }
}