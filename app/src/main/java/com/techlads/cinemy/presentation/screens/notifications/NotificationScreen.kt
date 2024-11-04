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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techlads.cinemy.presentation.components.CinemyTopAppBar
import kotlin.math.roundToInt

@Composable
fun NotificationsScreen() {


    Scaffold(
        topBar = {
            CinemyTopAppBar(
                title = "Notifications",
                showBackButton = false
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Divider()
                NotificationItem(
                    icon = Icons.Default.ThumbUp,
                    iconBackground = Color(0xFF4CAF50).copy(.2f),
                    title = "Congrats! You booked John Wick 3 movie ticket successfully.",
                    timestamp = "10:48:25 AM"
                )

                NotificationItem(
                    iconBackground = Color(0xFFFF5252),
                    title = "Hi Morgan. This is just a reminder for your movie today at 13:45 PM.",
                    timestamp = "3 hours ago",
                    icon = Icons.Default.Notifications
                )
                NotificationItem(
                    iconBackground = Color(0xFFFFC107),
                    title = "You've got a cashback for the past ticket booking.",
                    timestamp = "2 days ago",
                    icon = Icons.Default.Star
                )
                NotificationItem(
                    iconBackground = Color(0xFF03A9F4),
                    title = "You just got the discount 30% for booking a movie in this week.",
                    timestamp = "5 days ago",
                    icon = Icons.Default.ThumbUp
                )
                NotificationItem(
                    iconBackground = Color(0xFF4CAF50),
                    title = "Congrats! You booked John Wick 3 movie ticket successfully.",
                    timestamp = "4 weeks ago",
                    icon = Icons.Default.ThumbUp
                )
            }
        }
    }

}


@Composable
fun NotificationItem(iconBackground: Color, title: String, timestamp: String, icon: ImageVector) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(iconBackground.copy(0.2f), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    icon,
                    contentDescription = "notif_icon",
                    tint = iconBackground
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
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray, shape = DottedShape(step = 10.dp))
        )
    }
}


private data class DottedShape(
    val step: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val stepPx = with(density) { step.toPx() }
        val stepsCount = (size.width / stepPx).roundToInt()
        val actualStep = size.width / stepsCount
        val dotSize = Size(width = actualStep / 2, height = size.height)
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(x = i * actualStep, y = 0f),
                    size = dotSize
                )
            )
        }
        close()
    })
}