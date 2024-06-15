package com.dev_shivam.newzicon.home.presentation.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dev_shivam.newzicon.NEWS_SECTION
import com.dev_shivam.newzicon.NewziconViewModel
import com.dev_shivam.newzicon.home.presentation.models.HomeNews
import com.dev_shivam.newzicon.ui.theme.fontFamilyNewsreader


@Composable
fun HomeScreen(viewModel: NewziconViewModel) {
    val state = viewModel.homeScreenState.collectAsState().value
    val appState = viewModel.newziconStates.collectAsState().value


    LaunchedEffect(key1 = Unit) {
        viewModel.fetchTopStories()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column {

            // Top Section Bar
            TopSectionBar(state.selectedSection, viewModel::onClickSection)

            Spacer(modifier = Modifier.height(10.dp))


            if (state.homeNewsList.isEmpty()) {
                LoadingWidgetSections(section = state.selectedSection)
            } else {
                // Display loaded stories
                LazyColumn {
                    items(state.homeNewsList.size) {
                        HomeNewsItem(homeNews = state.homeNewsList[it])
                    }
                }
            }
        }

    }
}


@Composable
fun TopSectionBar(
    selectedSection: NEWS_SECTION,
    onClickSection: (NEWS_SECTION) -> Unit
) {

    val sections = rememberSaveable {
        NEWS_SECTION.entries
    }
    val lazyListState = rememberLazyListState()

    LazyRow(state = lazyListState) {
        items(sections.size) {
            val currentSection = sections[it]
            SectionItem(
                currentSection.toString(),
                currentSection == selectedSection
            ) {
                onClickSection(currentSection)
            }
        }
    }

    // Automatically scroll to the selected section when it changes
    LaunchedEffect(key1 = selectedSection) {
        val selectedIndex = sections.indexOfFirst { it == selectedSection }
        if (selectedIndex >= 0) {
            lazyListState.animateScrollToItem(selectedIndex, scrollOffset = -80)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewTopSectionBar() {
    TopSectionBar(selectedSection = NEWS_SECTION.WORLD) {
    }
}


@Composable
fun LoadingWidgetSections(section: NEWS_SECTION) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            fontSize = 16.sp,
            fontFamily = fontFamilyNewsreader,
            text = "Loading stories for \"$section\" "
        )

        Spacer(modifier = Modifier.height(10.dp))

        CircularProgressIndicator(
            modifier = Modifier.size(30.dp),
            color = Color.Black
        )
    }
}


//@Composable
//@Preview(showSystemUi = true)
//fun PreviewLoadingWidgetSections(){
//    LoadingWidgetSections(section = NYT_TOP_STORIES_SECTION.WORLD)
//}


@Composable
fun SectionItem(section: String, isSelected: Boolean, onClickSection: () -> Unit) {
    val backgroundColor: Color by animateColorAsState(
        targetValue = if (isSelected) Color.Black else Color.Transparent,
        animationSpec = tween(durationMillis = 200)
    )
    val textColor by animateColorAsState(targetValue = if (isSelected) Color.White else Color.Black)


    Text(
        modifier = Modifier
            .padding(5.dp)
            .clickable(
                enabled = true,
                onClick = onClickSection
            )
            .background(backgroundColor, CircleShape.copy(all = CornerSize(5.dp)))
            .padding(2.5.dp),
        text = section,
        color = textColor,
        fontFamily = fontFamilyNewsreader,
        fontSize = 22.sp
    )
}

//@Composable
//@Preview(showSystemUi = true)
//fun SectionItemPreview() {
//    SectionItem("Business", true) {}
//}


@Composable
fun HomeNewsItem(homeNews: HomeNews) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        AsyncImage(
            filterQuality = FilterQuality.Low,
            modifier = Modifier
                .size(85.dp)
                .padding(horizontal = 2.5.dp),
            model = homeNews.imageRes,
            contentScale = ContentScale.Crop,
            contentDescription = homeNews.title
        )
        Column {
            Text(
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 2.5.dp),
                fontSize = 18.sp,
                fontFamily = fontFamilyNewsreader,
                text = homeNews.title
            )

            Spacer(modifier = Modifier.height(5.dp))
            LinearProgressIndicator(modifier = Modifier
                .padding(horizontal = 2.5.dp)
                .height(1.dp),
                color = Color.Black,
                progress = {
                    100.0f
                })
        }


    }
}


//@Composable
//@Preview(showSystemUi = true)
//fun HomeNewsItemPreview() {
//    HomeNewsItem(
//        HomeNews(
//            "This is a sample text with sample picture",
//            "data:image/jpeg;base64,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"
//        )
//    )
//}

