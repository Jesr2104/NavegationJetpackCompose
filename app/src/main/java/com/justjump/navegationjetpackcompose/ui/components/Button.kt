package com.justjump.navegationjetpackcompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Button(label: String, enable: Boolean = true, onClick: () -> Unit){

    val upperCaseLabel = label.uppercase()

    Button(
        onClick = { onClick() },
        enabled = enable,
        modifier = Modifier
            .fillMaxWidth()
            .clickable{},
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
    ){ Text(upperCaseLabel) }
}

@Preview(showBackground = true)
@Composable
private fun ButtonPreview(){
    Box(modifier = Modifier.padding(20.dp)){
        Button("Button next screen"){}
    }
}