package com.jsadhu.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jsadhu.newsapp.presentation.Dimens
import com.jsadhu.newsapp.ui.theme.BlueGray

@Composable
fun PagerIndicator(
    selectedPage: Int,
    pageSize: Int,
    modifier: Modifier = Modifier,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray,
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(times = pageSize) { pageNo ->
            Box(
                modifier = Modifier
                    .size(Dimens.indicatorSize)
                    .padding(1.dp)
                    .clip(CircleShape)
                    .background(if (pageNo == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorPreview() {
    PagerIndicator(pageSize = 3, selectedPage = 2)
}