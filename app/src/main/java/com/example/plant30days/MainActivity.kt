package com.example.plant30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
                    exercise()
                }
            }
        }
    }
}

@Composable
fun exercise() {

}

@Composable
fun exerciseItems(exercise: Exercise, modifier: Modifier = Modifier) {
    Card() {

    }
}

//Composable for date and name 
@Composable
fun ExInfo(@StringRes exDay: Int, @StringRes exName: Int, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = stringResource(exDay)
        )
        Text(
            text = stringResource(exName)
        )

    }
}


//Composable for image
@Composable
fun exIcon(@DrawableRes exIcon: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(exIcon),
        contentDescription = null
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun GreetingPreview() {
    Plant30DaysTheme {
        exercise()
    }
}