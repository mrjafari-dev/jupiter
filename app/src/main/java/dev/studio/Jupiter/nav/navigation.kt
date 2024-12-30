package dev.studio.Jupiter.nav

import androidx.navigation.NavController


object Destination {
    const val Home = "home"
    const val ManifestScreen = "manifest/{roverName}"
}

class Action(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Destination.Home) }

    val manifest: (roverName: String) -> Unit = { roverName ->
        navController.navigate(Destination.ManifestScreen.plus("/${roverName}"))
    }
}