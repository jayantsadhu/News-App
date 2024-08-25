package com.jsadhu.newsapp.presentation.onboarding.components

import android.content.res.Configuration
import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jsadhu.newsapp.presentation.onboarding.Page
import com.jsadhu.newsapp.presentation.onboarding.pages
import com.jsadhu.newsapp.presentation.Dimens
import com.jsadhu.newsapp.R
import com.jsadhu.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnboardingPage(page: Page, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(fraction = 0.6f)
        )
        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(Dimens.mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(Dimens.mediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnboardingPreview() {
    NewsAppTheme {
        OnboardingPage(page = pages.get(0))
    }
}