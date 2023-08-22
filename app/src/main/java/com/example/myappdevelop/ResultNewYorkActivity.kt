package com.example.myappdevelop

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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


class ResultNewYorkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppDevelopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ResultNewyorkPreview()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ResultNewyorkPreview() {
    MyAppDevelopTheme {

        val context = LocalContext.current
        val onBackPressedDispatcher =
            LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
        val goBack: () -> Unit = {
            onBackPressedDispatcher.onBackPressed()
        }

        Box(modifier = Modifier.verticalScroll(rememberScrollState()))
        {
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 70.dp,
                        bottom = 120.dp
                    )
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
                            text = "뉴욕",
                            color = Color.Yellow,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ny),
                            contentDescription = "New York",
                            modifier = Modifier
                                .height(200.dp)
                                .width(400.dp),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(
                            text = "화려한 불빛이 나를 감싸는 곳!",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Text(
                            text = "당신이 선호하는 해외 여행지는 ",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Row {
                            Text(
                                text = "바로 ",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                            Text(
                                text = "뉴욕",
                                color = Color.Yellow,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                            )
                            Text(
                                text = "입니다.",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                            )
                        }
                        Row {
                            Text(
                                text = "타임스퀘어, 자유의 여신상 ",
                                color = Color.Yellow,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                            )
                            Text(
                                text = "등등!",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                            )

                        }
                        Text(
                            text = "화려한 여행지에서 화려한 여행을",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                        )
                        Text(
                            text = "추천합니다.",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 640.dp, bottom = 20.dp)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, data)
                            }
                            context.startActivity(Intent.createChooser(intent, null))
                        },
                        shape = RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF20B2AA)),
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 80.dp)
                    ) {
                        Text(
                            text = "공유하기",
                            fontSize = 20.sp
                        )
                    }

                    Button(
                        onClick = {
                            val url =
                                "https://www.hanatour.com/package/major-products?pkgServiceCd=FP&cityCd=NYC&cityNm=%EB%89%B4%EC%9A%95&rprsProdAirEnn=N,Y&prodTypeCd=I,G&areaNm=%EB%AF%B8%EC%A3%BC%2F%ED%95%98%EC%99%80%EC%9D%B4%2F%EC%BA%90%EB%82%98%EB%8B%A4&cityCatgAreaDvCd=C&prePage=%2F" // 여기에 접속하고자 하는 항공편/호텔 예약 페이지 URL을 입력하세요
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        },
                        shape = RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF00008B)),
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 80.dp)
                    ) {
                        Text(
                            text = "항공편/호텔 예약",
                            fontSize = 20.sp
                        )
                    }

                    Button(
                        onClick = {
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)
                        },
                        shape = RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFFF6347)),
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal =80.dp)
                    ) {
                        Text(
                            text = "테스트 다시하기",
                            fontSize = 20.sp
                        )
                    }

                    Button(
                        onClick = {
                            // drawable 리소스에서 비트맵 가져오기
                            val bitmap =
                                BitmapFactory.decodeResource(context.resources, R.drawable.boracay)

                            // MediaStore API를 사용하여 이미지 저장
                            val filename = "boracay_image_${System.currentTimeMillis()}.jpg"
                            val contentValues = ContentValues().apply {
                                put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                                put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                    put(
                                        MediaStore.MediaColumns.RELATIVE_PATH,
                                        Environment.DIRECTORY_PICTURES
                                    )
                                }
                            }

                            val resolver = context.contentResolver
                            val imageUri = resolver.insert(
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                contentValues
                            )
                            imageUri?.let {
                                val outputStream = resolver.openOutputStream(it)
                                outputStream?.use { stream ->
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                                    Toast.makeText(context, "이미지가 갤러리에 저장되었습니다", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }

                        },
                        shape = RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF999900)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 80.dp)
                    ) {
                        Text(
                            text = "이미지 저장",
                            fontSize = 20.sp
                        )
                    }
                }
            }

        }
    }
}
