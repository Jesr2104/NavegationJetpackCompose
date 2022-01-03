package com.justjump.navegationjetpackcompose.ui.navegation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
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
                    Screen1{ navController.navigate(NavItem.Screen2.createNavRouter(it)) }
                }

                // second navigation component to Screen 2 and to back
                composable(
                    route = NavItem.Screen2.route,
                    arguments = NavItem.Screen2.args
                ){ backStackEntry ->
                    val code = backStackEntry.arguments?.getString(NavArg.Code.Key)!!
                    Screen2(
                        code = code, //parameter
                        {navController.navigate(NavItem.Screen3.createNavRouter(it))},
                        {navController.popBackStack()}
                    )
                }

                // second navigation component to Screen 3 and to back
                composable(
                    route = NavItem.Screen3.route,
                    arguments = NavItem.Screen2.args
                ){ backStackEntry ->
                    val code = backStackEntry.arguments?.getString(NavArg.Code.Key)!!
                    Screen3(
                        code = code, //parameter
                        {navController.navigate(NavItem.Screen4.createNavRouter(it))},
                        {navController.popBackStack()}
                    )
                }

                // second navigation component to Screen 4 and to back
                composable(
                    route = NavItem.Screen4.route,
                    arguments = NavItem.Screen2.args
                ){
                    val code = it.arguments?.getString(NavArg.Code.Key)!!
                    Screen4(
                        code = code, //parameter
                        {},
                        {navController.popBackStack()},
                        {navController.navigate(NavItem.Screen1.route)}
                    )
                }
            }
        }
    }
}
