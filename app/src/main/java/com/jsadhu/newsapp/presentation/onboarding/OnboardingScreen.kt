package com.jsadhu.newsapp.presentation.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jsadhu.newsapp.presentation.Dimens.mediumPadding2
import com.jsadhu.newsapp.presentation.common.NewsButton
import com.jsadhu.newsapp.presentation.common.NewsTextButton
import com.jsadhu.newsapp.presentation.onboarding.components.OnboardingPage
import com.jsadhu.newsapp.presentation.onboarding.components.PagerIndicator
import com.jsadhu.newsapp.ui.theme.Black
import com.jsadhu.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    Column(modifier = modifier) {
        HorizontalPager(state = pagerState) { index ->
            OnboardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(weight = 1f))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = mediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PagerIndicator(selectedPage = pagerState.currentPage, pageSize = pagerState.pageCount)
            Row {
                val scope = rememberCoroutineScope()
                if (pagesButtonText[pagerState.currentPage].first != "")
                    NewsTextButton(
                        text = pagesButtonText[pagerState.currentPage].first,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    pagerState.currentPage - 1
                                )
                            }
                        },
                    )
                if (pagesButtonText[pagerState.currentPage].second != "")
                    NewsButton(
                        text = pagesButtonText[pagerState.currentPage].second,
                        onClick = {
                            scope.launch {
                                if (pagerState.currentPage == 2) {
                                    /*TODO*/
                                } else {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }
                        }
                    )
            }
        }
        Spacer(modifier = Modifier.weight(weight = 0.5f))
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Composable
fun OnboardScreenPreview() {
    NewsAppTheme {
        OnboardingScreen()
    }
}