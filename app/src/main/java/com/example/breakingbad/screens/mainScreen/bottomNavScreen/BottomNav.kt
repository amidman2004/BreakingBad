package com.example.breakingbad.screens.mainScreen.bottomNavScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavScreen() {
    val bottomNav = rememberNavController()

    val bottomNavCurrentDestination by bottomNav.currentBackStackEntryAsState()

    Scaffold(bottomBar = {
        BottomNavigation(Modifier.fillMaxWidth(),
            backgroundColor = Color.Gray) {
            BottomNavSreens.values().forEach { bottomNavScreen ->
                BottomNavigationItem(selected =
                bottomNavCurrentDestination?.destination?.route == bottomNavScreen.name,
                    onClick = {
                              bottomNav.navigate(bottomNavScreen.name)
                    },
                    icon = {
                        Icon(painter = painterResource(id = bottomNavScreen.icon),
                            contentDescription = null)},
                    label = {
                        Text(text = bottomNavScreen.name)
                    }
                )
            }
        }
    }) {
        NavHost(
            navController = bottomNav,
            startDestination = BottomNavSreens.Characters.name,
            modifier = Modifier.padding(bottom = it.calculateBottomPadding())){
            composable(BottomNavSreens.Characters.name){}
            composable(BottomNavSreens.Episodes.name){}
            composable(BottomNavSreens.Quotes.name){}
            composable(BottomNavSreens.Deaths.name){}
        }
    }
}