package com.guilhermeb.testmodularization

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilhermeb.testmodularization.ui.theme.TestModularizationTheme
import com.guilhermeb.view.MainViewActivity
import com.guilhermeb.viewcompose.MainComposeActivity

class MainActivity : ComponentActivity(), OpenActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestModularizationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    Screen(this)
                }
            }
        }
    }

    override fun open(type: String) {
        val intent: Intent?
        if (type.equals("XML")) {
            intent = Intent(this, MainViewActivity::class.java)
        } else if (type.equals("Compose")) {
            intent = Intent(this, MainComposeActivity::class.java)
        } else {
            return
        }
        startActivity(intent)
        //finish()
    }
}

interface OpenActivity {
    fun open(type: String)
}

@Composable
fun Screen(openActivity: OpenActivity) {
    Column(
        modifier = Modifier.fillMaxSize().padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                openActivity.open("XML")
            }
        ) {
            Text(
                text = "XML",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                openActivity.open("Compose")
            }
        ) {
            Text(
                text = "Compose",
                fontSize = 16.sp
            )
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
fun GreetingPreview() {
    TestModularizationTheme {
        Greeting("Android")
    }
}