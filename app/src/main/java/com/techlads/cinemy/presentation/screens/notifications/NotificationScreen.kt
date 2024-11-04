package com.techlads.cinemy.presentation.screens.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212))
                .padding(16.dp)
        ) {
            Text(
                text = "Notifications",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )



            NotificationItem(
                iconBackground = Color(0xFF4CAF50),
                title = "Congrats! You booked John Wick 3 movie ticket successfully.",
                timestamp = "10:48:25 AM"
            )

            NotificationItem(
                iconBackground = Color(0xFFFF5252),
                title = "Hi Morgan. This is just a reminder for your movie today at 13:45 PM.",
                timestamp = "3 hours ago"
            )

            NotificationItem(
                iconBackground = Color(0xFFFFC107),
                title = "You've got a cashback for the past ticket booking.",
                timestamp = "2 days ago"
            )

            NotificationItem(
                iconBackground = Color(0xFF03A9F4),
                title = "You just got the discount 30% for booking a movie in this week.",
                timestamp = "5 days ago"
            )

            NotificationItem(
                iconBackground = Color(0xFF4CAF50),
                title = "Congrats! You booked John Wick 3 movie ticket successfully.",
                timestamp = "4 weeks ago"
            )
        }
    }
}


@Composable
fun NotificationItem(iconBackground: Color, title: String, timestamp: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(iconBackground, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✓",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = timestamp,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}