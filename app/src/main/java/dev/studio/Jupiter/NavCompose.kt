package dev.studio.Jupiter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.studio.Jupiter.nav.Action
import dev.studio.Jupiter.nav.Destination
import dev.studio.Jupiter.ui.theme.JupiterTheme
import dev.studio.Jupiter.view.ManifestScreen
import dev.studio.Jupiter.view.RoverList

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) {  Action(navController)}
    JupiterTheme {
        NavHost(navController = navController, startDestination = Destination.Home) {
            composable(Destination.Home){
                RoverList(){value->
                    actions.manifest(value)
                }
            }
            composable(Destination.ManifestScreen){backStackEntry->
                ManifestScreen(roverName = backStackEntry.arguments?.getString("roverName"))
            }
        }
    }
}