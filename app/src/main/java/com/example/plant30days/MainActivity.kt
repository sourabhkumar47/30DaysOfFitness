package com.example.plant30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plant30days.model.Data.ExerciseRepo.exercises
import com.example.plant30days.model.Exercise
import com.example.plant30days.ui.theme.Plant30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Plant30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExerciseList()
                }
            }
        }
    }
}

@Composable
fun ExerciseList() {
    LazyColumn {
        items(exercises) {
            ExerciseItem(
                exercise = it
            )
        }
    }
}

@Composable
fun ExerciseItem(exercise: Exercise, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            ExInfo(exercise.dayRes, exercise.namRes)
            Spacer(modifier.weight(1f))
            ExIcon(exercise.desImage)
        }
    }
}

//Composable for date and name 
@OptIn(ExperimentalTextApi::class)
@Composable
fun ExInfo(
    @StringRes exDay: Int,
    @StringRes exName: Int
) {
//    Box {
    Column(
        modifier = Modifier
            .width(230.dp)
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val gradientColors = listOf(Color.Blue, Color.Red, Color.Magenta, Color.Green)
        Text(
            text = stringResource(exDay),
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Blue, blurRadius = 10f
                ),
                fontSize = 18.sp
            )
        )
        Text(
            text = stringResource(exName),
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                ),
                fontSize = 22.sp
            )
        )
//        }
    }

}


//Composable for image
@Composable
fun ExIcon(@DrawableRes exIcon: Int) {
    Image(
        painter = painterResource(exIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(90.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50))
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun GreetingPreview() {
    Plant30DaysTheme {
        ExerciseList()
    }
}