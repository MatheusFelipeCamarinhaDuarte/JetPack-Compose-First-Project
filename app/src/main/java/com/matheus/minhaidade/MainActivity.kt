package com.matheus.minhaidade

import android.os.Bundle
import android.util.Log
import android.widget.EdgeEffect
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheus.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Oculta a barra de notificações
        // enableEdgeToEdge()
        setContent {
            MinhaIdadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MeuComponente()
                }
            }
        }
    }
}

@Composable
fun MeuComponente(modifier: Modifier = Modifier) {

    var idade = remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        Text(
            text = "Qual a sua idade",
            color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            //modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Pressione os botões para informar a sua idade",
            fontSize = 12.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            //modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "${idade.value}",
            fontSize = 48.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    idade.value--;
                    Log.i("FIAP","$idade")
                },
                modifier = Modifier.size(84.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF88c6a5)),
                shape = RectangleShape
            ) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(modifier = Modifier.size(84.dp),
                onClick = {
                    idade.value++;
                    Log.i("FIAP","$idade")
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF88c6a5)),
                shape = RectangleShape
            ) {
                Text(text = "+")
            }
        }
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MeuComonentePreview() {

    MeuComponente()
}