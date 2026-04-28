package com.example.tugaspam3.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugaspam3.R
import com.example.tugaspam3.model.ProfileUiState

@Composable
fun ProfileHeader(state: ProfileUiState) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = state.name, 
            fontSize = 22.sp, 
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = state.nim, 
            fontSize = 18.sp, 
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = state.bio, 
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
