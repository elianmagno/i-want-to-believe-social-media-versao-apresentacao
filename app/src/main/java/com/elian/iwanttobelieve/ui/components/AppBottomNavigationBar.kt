package com.elian.iwanttobelieve.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elian.iwanttobelieve.navigation.Routes


@Composable
fun AppBottomNavigationBar(
    currentRoute: String?,
    onNavigateToFeed: () -> Unit,
    onNavigateToPost: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.scrim.copy(alpha = 0.06f)
    ) {
        val items = listOf(
            Triple(Routes.Feed.id, Icons.Default.Home, "Feed"),
            Triple(Routes.Post.id, Icons.Default.Add, "Post"),
            Triple(Routes.Profile.id, Icons.Default.Person, "Profile")
        )

        items.forEach { (route, icon, label) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = {
                    when (route) {
                        Routes.Feed.id -> onNavigateToFeed()
                        Routes.Post.id -> onNavigateToPost()
                        Routes.Profile.id -> onNavigateToProfile()
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        modifier = Modifier.size(32.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.scrim,
                    unselectedIconColor = MaterialTheme.colorScheme.scrim,
                    indicatorColor = MaterialTheme.colorScheme.tertiary
                )
            )
        }
    }
}