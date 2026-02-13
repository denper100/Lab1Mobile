package com.mobileApp.lab1

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BusinessCardScreen() {
    val configuration = LocalConfiguration.current

    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileSection()
            ContactSection()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ProfileSection()
            }

            ContactSection(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = dimensionResource(R.dimen.spacing_medium))
            )
        }
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(dimensionResource(R.dimen.avatar_container_size))
                .background(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(
                        dimensionResource(R.dimen.avatar_corner_radius)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier.size(
                    dimensionResource(R.dimen.avatar_image_size)
                )
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_medium)))

        Text(
            text = stringResource(R.string.name),
            fontSize = dimensionResource(R.dimen.text_large).value.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_small)))

        Text(
            text = stringResource(R.string.group),
            fontSize = dimensionResource(R.dimen.text_medium).value.sp
        )
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = stringResource(R.string.email),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.spacing_small)))

        Text(
            text = stringResource(R.string.email),
            fontSize = dimensionResource(R.dimen.text_medium).value.sp
        )
    }
}
