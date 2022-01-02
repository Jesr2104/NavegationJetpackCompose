package com.justjump.navegationjetpackcompose.ui.navegation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.justjump.navegationjetpackcompose.ui.screens.Screen1
import com.justjump.navegationjetpackcompose.ui.screens.Screen2
import com.justjump.navegationjetpackcompose.ui.screens.Screen3
import com.justjump.navegationjetpackcompose.ui.screens.Screen4
import com.justjump.navegationjetpackcompose.ui.theme.NavegationJetpackComposeTheme

@Composable
fun NavegationHost(){
    val navController = rememberNavController()

    // we apply the theme in all the screens
    NavegationJetpackComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            //Navigation Host
            NavHost(navController = navController, NavItem.Screen1.route){

                // first navigation component to Screen 1
                composable( route = NavItem.Screen1.route ){
                    Screen1{ navController.navigate(NavItem.Screen2.route) }
                }

                // second navigation component to Screen 2 and to back
                composable( route = NavItem.Screen2.route ){
                    Screen2(
                        {navController.navigate(NavItem.Screen3.route)},
                        {navController.popBackStack()}
                    )
                }

                // second navigation component to Screen 3 and to back
                composable( route = NavItem.Screen3.route ){
                    Screen3(
                        {navController.navigate(NavItem.Screen4.route)},
                        {navController.popBackStack()}
                    )
                }

                // second navigation component to Screen 4 and to back
                composable( route = NavItem.Screen4.route ){
                    Screen4(
                        {},
                        {navController.popBackStack()},
                        {navController.navigate(NavItem.Screen1.route)}
                    )
                }
            }
        }
    }
}
