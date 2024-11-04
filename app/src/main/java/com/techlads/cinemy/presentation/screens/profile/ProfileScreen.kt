package com.techlads.cinemy.presentation.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.techlads.cinemy.presentation.components.CinemyTopAppBar
import com.techlads.cinemy.ui.theme.CinemyTheme
import com.techlads.cinemy.R.drawable

val buttons = listOf(
    ProfileButton(title = "Account Information", leadingIcon = drawable.ic_person),
    ProfileButton(title = "Transactions History", leadingIcon = drawable.ic_round_dollar),
    ProfileButton(title = "Ratting App", leadingIcon = drawable.ic_fav_list),
    ProfileButton(title = "Privacy Policy", leadingIcon = drawable.ic_folder),
)

@Composable
fun ProfileScreen() {


    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CinemyTopAppBar(
                title = "Profile",
                showBackButton = false
            )
        },
        bottomBar = {
        }
    ) { innerPadding ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(CinemyTheme.colors.primarySoft)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            item {
                ProfilePictureSection(
                    size = 130.dp,
                    name = "Rish Tran",
                    imageUrl = "https://pixy.org/placeholder/658ec27635331.jpg"
                )
            }
            item {
                RatingSection()
            }

            items(buttons) { button ->
                BorderLineButton(
                    button = button,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                )
            }
        }
    }
}


@Composable
fun ProfilePictureSection(
    size: Dp,
    name: String,
    imageUrl: String
) {
    Column(
        modifier = Modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        placeholder(drawable.ic_person)
                        crossfade(true)
                    }).build()
            ),
            modifier = Modifier
                .size(size)
                .padding(8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = "Character"
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                color = CinemyTheme.colors.primaryDark,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            memberBadge()
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "yasir896@gmail.com",
                color = CinemyTheme.colors.grey.copy(0.7f),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun RatingSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RatingSubSection(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            rating = "123",
            description = "TOTAL POINTS"
        )

        Spacer(
            modifier = Modifier
                .width(1.dp)
                .height(60.dp)
                .background(color = CinemyTheme.colors.grey.copy(0.5f))
        )

        RatingSubSection(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            rating = "06",
            description = "MOVIES WATCHED"
        )

    }
}

@Composable
fun RatingSubSection(
    modifier: Modifier,
    rating: String,
    description: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = rating,
            color = CinemyTheme.colors.primaryDark,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = description,
            color = CinemyTheme.colors.grey.copy(0.7f),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )

    }
}

@Composable
fun memberBadge() {
    Surface(
        color = CinemyTheme.colors.green.copy(0.2f),
        shape = RoundedCornerShape(5.dp),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "MEMBER",
            color = CinemyTheme.colors.green,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )
    }

}

@Composable
fun BorderLineButton(
    modifier: Modifier,
    button: ProfileButton
) {
    Surface(
        modifier = modifier
            .clickable { },
        color = CinemyTheme.colors.primarySoft,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(width = 2.dp, color = CinemyTheme.colors.grey.copy(0.2f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = button.leadingIcon),
                contentDescription = ""
            )

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = button.title,
                color = CinemyTheme.colors.grey.copy(0.7f),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = drawable.baseline_arrow_forward),
                tint = CinemyTheme.colors.grey.copy(0.3f),
                contentDescription = ""
            )
        }
    }
}

data class ProfileButton(val title: String, val leadingIcon: Int)

