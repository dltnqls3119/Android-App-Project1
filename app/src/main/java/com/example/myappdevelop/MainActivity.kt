package com.example.myappdevelop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappdevelop.ui.theme.MyAppDevelopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppDevelopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityPreview()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    MyAppDevelopTheme {

        val context = LocalContext.current

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "나에게 딱 맞는",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp
                )
                Text(
                    text = "해외 여행지",
                    color = Color(0xFFFF6347),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp
                )
                Text(
                    text = "추천",
                    color = Color(0xFF1E90FF),
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }



        Box(
            Modifier
                .fillMaxSize()
                .padding(top = 300.dp)
        ) {


            Image(
                painter = painterResource(id = R.drawable.travel),
                contentDescription = "Travel Image",
                alignment = Alignment.Center
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 130.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        val intent = Intent(context, Question1Activity::class.java)
                        context.startActivity(intent)
                    },
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.buttonColors(Color.Yellow)
                ) {
                    Text(
                        text = "시작하기",
                        color = Color.Black,
                        fontSize = 30.sp
                    )
                }
            }
        }

    }
}