package com.example.plant30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    LazyColumn(
//        modifier = Modifier
//            .padding(
//                start = 16.dp,
//                end = 16.dp,
//                top = 16.dp
//            )
    ) {
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
@Composable
fun ExInfo(
    @StringRes exDay: Int,
    @StringRes exName: Int
) {
    Column(
    ) {
        Text(
            text = stringResource(exDay),
            Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(exName),
            Modifier.padding(top = 8.dp)
        )
    }
}


//Composable for image
@Composable
fun ExIcon(@DrawableRes exIcon: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(exIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
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