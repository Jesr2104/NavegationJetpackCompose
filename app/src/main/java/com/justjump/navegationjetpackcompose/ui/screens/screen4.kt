package com.justjump.navegationjetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justjump.navegationjetpackcompose.R
import com.justjump.navegationjetpackcompose.ui.components.Button
import com.justjump.navegationjetpackcompose.ui.components.TopBar

@Composable
fun Screen4(onClick: () -> Unit, onClickToBack: () -> Unit, onClickToHome: () -> Unit){
    Scaffold(
        topBar = {
            TopBar(title = stringResource(R.string.title_screen4)){
                // event to navigate back on the stack!!
                onClickToBack()
            }
        },
        content =  {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("You are in the fourth screen", fontWeight = FontWeight(600), fontSize = 20.sp)
                Column(modifier = Modifier.padding(30.dp,10.dp,30.dp,10.dp)) {
                    Button("Button next screen",false){
                        // event to navigate to the next Screen!!
                        onClick()
                    }
                }
                Text("4", fontWeight = FontWeight(700), fontSize = 200.sp)
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Button("Back Home"){
                    // event to go back to the home screen!!
                    onClickToHome()
                }
            }
        }
    )
}