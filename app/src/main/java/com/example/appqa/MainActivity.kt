package com.example.appqa

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appqa.ui.theme.AppQATheme
import com.example.appqa.ui.theme.DebugButtonColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppQATheme {
                App();
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun App(

) {
    val context = LocalContext.current;
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,


            )
        {
            Greeting("QA")
            ActionButton(

                text = "Clique aqui",
                buttonColors = DebugButtonColors(),

                ) {

                Log.d(ContentValues.TAG, "App: Clicou no botão")
                Toast.makeText(context, "App: Clicou no botão", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun AppPreview() {
    AppQATheme {
        App();
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit,
) {
    ElevatedButton(
        //modifier = Modifier.semantics {contentDescription = "btnCliqueAqui", text = "btnText",

        //modifier = Modifier.semantics { testTag = "btnCliqueAquiTestTag"},
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
    ) {
        Text(text = text)

    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview() {
    ActionButton(
        text = "Action",

        ) {

    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppQATheme {
        Greeting("Android")
    }
}
