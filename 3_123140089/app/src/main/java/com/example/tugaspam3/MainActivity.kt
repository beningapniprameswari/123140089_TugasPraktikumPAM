package com.example.tugaspam3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyProfileApp()
        }
    }
}

@Composable
fun MyProfileApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFE4EC)
    ) {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ProfileHeader()

        Spacer(modifier = Modifier.height(20.dp))

        ProfileCard()
    }
}

@Composable
fun ProfileHeader() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Bening Apni Prameswari",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "123140089",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Mahasiswa Teknik Informatika ITERA Angkatan 2023",
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProfileCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF0F5)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            InfoItem(Icons.Default.Email, "Email", "bening.123140089@student.itera.ac.id")
            InfoItem(Icons.Default.Phone, "Phone", "+6281366031307")
            InfoItem(Icons.Default.LocationOn, "Location", "Bandar Lampung")

        }

    }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE91E63)
                )
            ) {
                Text("Detail Profile")
            }
}

@Composable
fun InfoItem(icon: ImageVector, title: String, value: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {

        Icon(
            imageVector = icon,
            contentDescription = title
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {

            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )

            Text(text = value)

        }
    }
}