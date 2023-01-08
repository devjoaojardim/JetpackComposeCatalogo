package com.jvjp.jetpackcomposecatalogo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MarkEmailRead
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jvjp.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var states by remember { mutableStateOf("Aris") }
                    var show by remember { mutableStateOf(false) }
                    val myOptions = getOptions(title = listOf("Hola", " Gusto Mucho", "Mazanrana"))
                    Column() {
//                        MyBagdeBox()
                        //MyTrieStatusCheckBox()
//                        MyRadioButtonList(states, { states = it })
//                        myOptions.forEach {
//                            MyCheckBoxWithTextCompleted(it)
//                        }
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Button(onClick = { show = true }) {
                                Text(text = "Mostra Dialogo")
                            }

//                            MyAlertDialog(show = show, onDismiss = { show = false },
//                                onConfirm = {
//                                    show = false
//                                Toast.makeText(
//                                    this@MainActivity,
//                                    "Funcionou certinho",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            })
                            MyConfirmDialog(show = show, onDismiss = { show = false })
                        }

                        // MyDropdownMenu()

                    }
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyDropdownMenu()
    }
}

@Composable
fun MyDropdownMenu() {
    var selectText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Café", "Fruta", "Natillas", "Chilaqiles")


    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectText,
            onValueChange = { selectText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth())
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { desserts ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectText = desserts
                }) {
                    Text(text = desserts)
                }
            }
        }

    }


}

@Composable
fun MyDivider() {
    var states by rememberSaveable { mutableStateOf(false) }

    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp), color = Color.Blue
    )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyBagdeBox() {
    var states by rememberSaveable { mutableStateOf(false) }

    BadgedBox(
        modifier = Modifier.padding(60.dp),
        badge = {
            Badge(
                content = {
                    Text(modifier = Modifier.padding(2.dp), text = "1")
                },
                backgroundColor = Color.Black,
                contentColor = Color.White,
                modifier = Modifier.padding(0.dp)
            )
        },
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Default.Notifications,
            contentDescription = "l",
            tint = Color.Blue
        )
    }

}

@Composable
fun MyCard() {
    var states by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.large
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
            Text(text = "Ejemplo 4")
        }
    }


}


@Composable
fun MyRadioButton() {
    var states by rememberSaveable { mutableStateOf(false) }

    Column() {
        Row() {
            RadioButton(
                selected = states,
                onClick = { states = !states },
            )
            Text(text = "Ola Mundao", Modifier.padding(top = 12.dp))
        }
    }


}

@Composable
fun MyRadioButtonList(states: String, onItemSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(selected = states == "Aris", onClick = { onItemSelected("Aris") })
            Text(text = "Aris", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(
                selected = states == "Joao",
                onClick = { onItemSelected("Joao") },
            )
            Text(text = "Joao", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(
                selected = states == "Maisa",
                onClick = { onItemSelected("Maisa") },
            )
            Text(text = "Maisa", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(
                selected = states == "Bruce",
                onClick = { onItemSelected("Bruce") },
            )
            Text(text = "Bruce", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(
                selected = states == "Peter",
                onClick = { onItemSelected("Peter") },
            )
            Text(text = "Peter", Modifier.padding(top = 12.dp))
        }
    }


}

@Composable
fun getOptions(title: List<String>): List<CheckInfo> {
    return title.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = {
                status = it
            }
        )
    }

}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {


    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Text(text = checkInfo.title, Modifier.padding(top = 12.dp))
    }


}


@Composable
fun MyCheckBoxWithText() {
    var states by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = states, onCheckedChange = { states = !states })
        Text(text = "Ola Mundo", Modifier.padding(top = 12.dp))
    }


}

@Composable
fun MyTrieStatusCheckBox() {
    var states by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = states, onClick = {
        states = when (states) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })

//    Checkbox(
//        state = states,
//        onCheckedChange = { states = !states },
//        colors = CheckboxDefaults.colors(
//            checkedColor = Color.Green,
//            uncheckedColor = Color.Red,
//        )
//    )


}

@Composable
fun MyCheckBox() {
    var states by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = states,
        onCheckedChange = { states = !states },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green,
            uncheckedColor = Color.Red,
        )
    )


}

@Composable
fun MySwitch() {
    var states by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = states,
        onCheckedChange = { states = !states },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
        )
    )

}

@Composable
fun MyProgressBarAvancado() {

    var showLoadingProgress by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LinearProgressIndicator(color = Color.Magenta, progress = showLoadingProgress)

        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { showLoadingProgress = showLoadingProgress + 0.1f },
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Text(text = "Incrementar")
            }
            Button(
                onClick = { showLoadingProgress = showLoadingProgress - 0.1f },
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Text(text = "Reducir")
            }
        }

    }
}

@Composable
fun MyProgressBar() {
    var showLoadingProgress by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (showLoadingProgress) {
            CircularProgressIndicator(color = Color.Magenta)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Gray,
                backgroundColor = Color.LightGray
            )
        }
        Button(onClick = { showLoadingProgress = true }, modifier = Modifier.padding(top = 15.dp)) {
            Text(text = "Click")
        }

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

