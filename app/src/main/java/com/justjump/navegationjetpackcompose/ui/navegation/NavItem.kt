package com.justjump.navegationjetpackcompose.ui.navegation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList())
{
    // don't forget to specify the list of parameters
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
        object Screen1: NavItem("screen1")
        object Screen2: NavItem("screen2")
        object Screen3: NavItem("screen3")
        object Screen4: NavItem("screen4")

    //----------------------------------------------------------------------

    // this run create the navigation route with its parameters
    // for eg: baseRoute/{param1}...
    val route = run {
        val argKeys = navArgs.map { "{${it.Key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map { navArgument(it.Key){ type = it.navType} }
}

enum class NavArg(val Key: String, val navType: NavType<*>) {}