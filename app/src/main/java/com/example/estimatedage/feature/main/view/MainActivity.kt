package com.example.estimatedage.feature.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.estimatedage.App
import com.example.estimatedage.R
import com.example.estimatedage.feature.main.viewModel.MainViewModel
import com.example.estimatedage.ui.theme.EstimatedAgeTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstimatedAgeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    App()
                }
            }
        }
    }


    @Composable
    fun App() {
        val name = viewModel.state.value.name
        val age = viewModel.state.value.age
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ){
                TextField(
                    value = name,
                    onValueChange = { textChanged ->
                        viewModel.state.value.name = textChanged
                    },
                    modifier = Modifier
                        .width(320.dp)
                        .fillMaxHeight()
                        .padding(start = 30.dp, end = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    maxLines = 1,
                )
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search image",
                    modifier = Modifier
                        .background(
                            Color.Red,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .padding(10.dp)
                        .clickable {
                            viewModel.findPerson(name)
                        }
                )
            }

            Text(
                text = if(name == "") "" else getString(R.string.age_result, name, age),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        EstimatedAgeTheme {
            EstimatedAgeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    App()
                }
            }
        }
    }
}
