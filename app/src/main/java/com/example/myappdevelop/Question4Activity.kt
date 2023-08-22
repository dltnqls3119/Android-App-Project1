package com.example.myappdevelop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappdevelop.ui.theme.MyAppDevelopTheme

class Question4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppDevelopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Question4Preview()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Question4Preview() {
    MyAppDevelopTheme {

        val context = LocalContext.current
        val onBackPressedDispatcher =
            LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
        val goBack: () -> Unit = {
            onBackPressedDispatcher.onBackPressed()
        }

        Box {
            Button(
                onClick = goBack, // 이전 화면으로 돌아가는 동작
                modifier = Modifier.padding(10.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(Color(0xFFD3D3D3)),

                ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "ArrowLeftImage",
                    tint = Color.Black
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Q4.",
                        color = Color.Green,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                    )
                    Text(
                        text = "여행지에 가서 현지 음식을 즐겨 먹는 편이다.",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp

                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                val intent = Intent(context, Question5Activity::class.java)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFFA9A9A9))
                        ) {
                            Text(
                                text = "YES",
                                fontSize = 25.sp
                            )
                        }
                        Button(
                            onClick = {
                                val intent = Intent(context, Question6Activity::class.java)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFFA9A9A9))
                        ) {
                            Text(
                                text = "NO",
                                fontSize = 25.sp
                            )
                        }
                    }
                }

            }
        }
        Box(
            modifier = Modifier.padding(
                top = 710.dp,
                end = 10.dp,
                bottom = 10.dp
            )
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier.fillMaxSize()
                    .size(150.dp),
                painter = painterResource(id = R.drawable.vacation5),
                contentDescription = "Vacation Image",
                alignment = Alignment.BottomEnd
            )
        }
    }
}