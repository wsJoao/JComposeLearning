package com.jppin.composelearning.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jppin.composelearning.Feature
import com.jppin.composelearning.R
import com.jppin.composelearning.ui.theme.*

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FilterSection(filters = listOf("Most recent", "Not listened", "Listened"))
            FeaturesGrid(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.baseline_headphones_24,
                        DarkerButtonBlue
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.baseline_videocam_24,
                        LightGreen1
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.baseline_headphones_24,
                        OrangeYellow1
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.baseline_headphones_24,
                        LightRed
                    ),
                )
            )
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "John"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .padding(top = 20.dp)
    ) {
        Column(
        ) {
            Text(
                text = "Good morning, $name",
                fontFamily = gothicaFontFamily, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Text(
                text = "We wish you have a good day!",
                fontFamily = gothicaFontFamily, fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(R.drawable.baseline_search_24),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(30.dp),
        )
    }
}
@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember{
        mutableIntStateOf(0)
    }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            items(chips.size) { index ->
                val isSelected = selectedChipIndex == index
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected) ButtonBlue else DarkerButtonBlue,
                    label = "Chip background color"
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(backgroundColor)
                        .clickable {
                            selectedChipIndex = index
                        }
                        .padding(15.dp)
                ) {
                    Text(text = chips[index], color = TextWhite,
                    fontFamily = gothicaFontFamily, fontWeight = FontWeight.ExtraBold,)
                }
            }
        }
    }

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row (
        verticalAlignment =  Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite,
                fontFamily = gothicaFontFamily, fontWeight = FontWeight.ExtraBold,
            )
            Text(
                text = "15 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite,
                fontFamily = gothicaFontFamily, fontWeight = FontWeight.Light,
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable {
                }
                .background(ButtonBlue)
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(60.dp)
            )
        }
    }
}

@Composable
fun FilterSection (
    filters : List<String>
) {
    var selectedFilterIndex by remember {
        mutableIntStateOf(0)
    }
    Text(
        text = "Filters",
        style = MaterialTheme.typography.headlineMedium,
        color = TextWhite,
        fontFamily = gothicaFontFamily, fontWeight = FontWeight.ExtraBold,
        modifier = Modifier
            .padding(start = 15.dp, top = 15.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 5.dp, bottom = 15.dp)

    ){
        items(filters.size) { index ->
            val isSelected = selectedFilterIndex == index
            val backgroundColor by animateColorAsState(
                targetValue = if (isSelected) LightGreen1 else DarkerButtonBlue,
                label = "Chip background color"
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 10.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(backgroundColor)
                    .clickable {
                        selectedFilterIndex = index
                    }
                    .padding(5.dp)
            ){
                Text(text = filters[index], color = TextWhite
                    , fontFamily = gothicaFontFamily, fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Composable
fun FeaturesGrid(
    features: List<Feature>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Featured",
            style = MaterialTheme.typography.headlineMedium,
            color = TextWhite,
            fontFamily = gothicaFontFamily, fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp, top = 20.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .padding(horizontal = 10.dp, vertical = 15.dp)
            .background(feature.lightColor, RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 40.sp,
                color = TextWhite,
                fontFamily = gothicaFontFamily,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(feature.iconId),
                    contentDescription = feature.title,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .size(35.dp)
                )
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontFamily = gothicaFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonBlue)
                        .clickable { }
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}


