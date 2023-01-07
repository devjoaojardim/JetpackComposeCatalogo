package com.jvjp.jetpackcomposecatalogo

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MarkEmailRead
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jvjp.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import com.jvjp.jetpackcomposecatalogo.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyIcon()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyIcon()
    }
}
@Composable
fun MyIcon() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Filled.MarkEmailRead,
            contentDescription = "ejexplo"
        )
        Icon(
            imageVector = Icons.Filled.Lock,
            contentDescription = "ejexplo"
        )

    }
}
@Composable
fun MyImage() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.joao),
            contentDescription = "ejexplo",
            alpha = 0.5f
        )

    }
}

@Composable
fun MyImageAdvance() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejexplo",
            alpha = 0.5f,
            modifier = Modifier
                .clip(CircleShape)
                .border(2.dp, Color.Black, CircleShape)
        )
        //  RoundedCornerShape(25.dp)
    }
}

@Composable
fun MyStatesExample() {
    var click by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { click += 1 }) {
            Text(text = "Click aqui")
        }
        Text(text = "Fui clicado ${click} vezes")


    }

}

@Composable
fun MyButton() {

    var enable by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(end = 16.dp, start = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { enable = true },
            Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),
            border = BorderStroke(5.dp, Color.Black)
        ) {
            Text(text = "Click", color = Color.White)
        }

        Button(
            onClick = { enable = false },
            Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red),
            border = BorderStroke(5.dp, Color.Black),
            enabled = enable
        ) {
            Text(text = "No funcion", color = Color.White)
        }

        OutlinedButton(
            onClick = { enable = false },
            Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                Color.Yellow,
                disabledBackgroundColor = Color.Green
            ),
            enabled = enable
        ) {
            Text(text = "funcion", color = Color.Black)
        }

        TextButton(onClick = { enable = true }, Modifier.fillMaxWidth()) {
            Text(text = "Hola")
        }
    }
}


@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow), contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello, i am João", color = Color.Blue, fontStyle = FontStyle.Italic)
        }
        MySpacer(size = 16)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Hello, i am João", color = Color.Blue, fontStyle = FontStyle.Italic)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Hello, i am João", color = Color.Blue, fontStyle = FontStyle.Italic)
            }
        }
        MySpacer(size = 16)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Blue), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Hello, i am João", color = Color.Red, fontStyle = FontStyle.Italic)
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    //Layout Row
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ola mundo1", modifier = Modifier
                .background(Color.Blue)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo2", modifier = Modifier
                .background(Color.Red)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo3", modifier = Modifier
                .background(Color.Green)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo4", modifier = Modifier
                .background(Color.Cyan)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo1", modifier = Modifier
                .background(Color.Blue)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo2", modifier = Modifier
                .background(Color.Red)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo3", modifier = Modifier
                .background(Color.Green)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo4", modifier = Modifier
                .background(Color.Cyan)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo1", modifier = Modifier
                .background(Color.Blue)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo2", modifier = Modifier
                .background(Color.Red)
                .width(250.dp)
                .height(300.dp)
        )
        Text(
            text = "Ola mundo3", modifier = Modifier
                .background(Color.Green)
                .width(250.dp)
                .height(300.dp)
        )
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Imagem Vi"
        )
        Text(
            text = "Ola mundo4", modifier = Modifier
                .background(Color.Cyan)
                .width(250.dp)
                .height(300.dp)
        )
    }

}

@Composable
fun MyColumn() {
    //Layout Column
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ola mundo1", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo2", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo3", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo1", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo2", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo3", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo1", modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo2", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo3", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ola mundo4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(80.dp)
        )
    }

}

@Composable
fun MyBox() {
    //Layout Box
//    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.CenterEnd) {
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Blue)){
//            Text(text = "Ola mundo")
//        }
//
//    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.CenterEnd
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Text(text = "Ola mundo")
        }

    }
}

