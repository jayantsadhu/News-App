package com.jsadhu.newsapp.presentation.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jsadhu.newsapp.presentation.common.NewsButton
import com.jsadhu.newsapp.presentation.onboarding.components.OnboardingPage
import com.jsadhu.newsapp.presentation.onboarding.components.PagerIndicator
import com.jsadhu.newsapp.ui.theme.Black
import com.jsadhu.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    HorizontalPager(state = pagerState) { index ->
        Column(modifier = modifier) {
            OnboardingPage(page = pages[index])
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PagerIndicator(selectedPage = index, pageSize = pages.size)
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                    if (pagesButtonText[index].first != "")
                        NewsButton(
                            text = pagesButtonText[index].first,
                            onClick = { /*TODO*/ },)
                    if (pagesButtonText[index].second != "")
                        NewsButton(
                            text = pagesButtonText[index].second,
                            onClick = { /*TODO*/ })
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnboardScreenPreview() {
    NewsAppTheme {
        OnboardingScreen()
    }
}