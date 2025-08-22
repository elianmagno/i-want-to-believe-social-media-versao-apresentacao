package com.elian.iwanttobelieve.ui.screens.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elian.iwanttobelieve.R
import com.elian.iwanttobelieve.ui.model.PostWithAuthor
import com.elian.iwanttobelieve.navigation.Routes
import com.elian.iwanttobelieve.ui.components.AppBottomNavigationBar
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel(),
    onNavigateToPost: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()
    val postsWithAuthor = uiState.postsWithAuthor
    val isLoading = uiState.isLoading
    val errorMessage: String? = uiState.errorMessage?.let { stringResource(id = it.messageResId) }

    LaunchedEffect(key1 = true) {
        viewModel.observePosts()
    }

    LaunchedEffect(key1 = true) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is FeedViewModel.NavigationEvent.NavigateToPost -> onNavigateToPost()
                is FeedViewModel.NavigationEvent.NavigateToProfile -> onNavigateToProfile()
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {
            AppBottomNavigationBar(
                currentRoute = Routes.Feed.id,
                onNavigateToFeed = { },
                onNavigateToPost = { viewModel.onPostNavigationRequested() },
                onNavigateToProfile = { viewModel.onProfileNavigationRequested() }
            )
        }

    ) { innerPadding ->
        val statusBarTop = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(statusBarTop)
                .background(MaterialTheme.colorScheme.primary)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(40.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background),
                    contentScale = ContentScale.Fit
                )
            }

            if (errorMessage != null) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error,
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                items(postsWithAuthor) { postWithAuthor ->
                    Post(postWithAuthor = postWithAuthor)
                }
            }

        }

        if(isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.4f))
                    .clickable(enabled = true, onClick = { }),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(60.dp),
                    strokeWidth = 4.dp
                )
            }
        }
    }
}

@Composable
fun Post(postWithAuthor: PostWithAuthor) {

    val post = postWithAuthor.post
    val author = postWithAuthor.author

    val description = post.description
    val imageUrl = post.imageUrl
    val timestamp = post.timestamp

    val timestampText = {
        val fmt = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        fmt.format(timestamp)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = author?.imageUrl ?: R.drawable.profile,
                contentDescription = "Author image",
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = author?.name ?: "Unknown",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.scrim,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = timestampText(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.scrim.copy(alpha = 0.5f),
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.scrim,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        AsyncImage(
            model = imageUrl,
            contentDescription = "Post image",
            modifier = Modifier
                .fillMaxWidth()
                .size(280.dp),

            contentScale = ContentScale.Crop
        )
    }
}