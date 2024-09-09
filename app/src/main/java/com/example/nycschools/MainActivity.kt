package com.example.nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nycschools.ui.Body
import com.example.nycschools.ui.SchoolDetails
import com.example.nycschools.ui.SchoolDetailsScreen
import com.example.nycschools.ui.SearchBar
import com.example.nycschools.ui.theme.NYCSchoolsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYCSchoolsTheme {
                Column {
                    Body()
                    SchoolDetailsScreen()
//                    MyAppNavHost()
                }

            }
        }
    }
}

//@Composable
//fun MyAppNavHost(){
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "SchoolDetails") {
//        composable("SchoolDetails"){
//            SchoolDetailsScreen{
//                navController.navigate("SchoolMoreDetails")
//            }
//        }
//        composable("SchoolMoreDetails"){
//            SchoolDetails()
//        }
//
//    }
//}