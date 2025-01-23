package com.jppin.composelearning.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jppin.composelearning.R
import com.jppin.composelearning.ui.theme.ButtonBlue
import com.jppin.composelearning.ui.theme.DarkerButtonBlue
import com.jppin.composelearning.ui.theme.DeepBlue
import com.jppin.composelearning.ui.theme.LightRed
import com.jppin.composelearning.ui.theme.TextWhite

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
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(R.drawable.baseline_search_24),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(30.dp)
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
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }

    }
}
@Preview
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
                color = TextWhite
            )
            Text(
                text = "15 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )

        }

    }
}
@Preview
@Composable
fun FeatureSection (

) {

}

@Preview
@Composable
fun ChipSectionPreview() {
    ChipSection(chips = listOf("Opção 1", "Opção 2", "Opção 3"))
}

