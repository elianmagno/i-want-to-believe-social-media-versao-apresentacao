package com.elian.iwanttobelieve.ui.screens.post

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elian.iwanttobelieve.R
import com.elian.iwanttobelieve.navigation.Routes
import com.elian.iwanttobelieve.ui.components.AppBottomNavigationBar
import com.elian.iwanttobelieve.ui.util.uriToJpegByteArray
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostScreen(
    viewModel: PostViewModel = hiltViewModel(),
    onNavigateToFeed: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val isLoading = uiState.isLoading
    val errorMessage: String? = uiState.errorMessage?.let { stringResource(id = it.messageResId) }

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    var description by remember { mutableStateOf("") }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    LaunchedEffect(key1 = true) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is PostViewModel.NavigationEvent.NavigateToFeed -> onNavigateToFeed()
                is PostViewModel.NavigationEvent.NavigateToProfile -> onNavigateToProfile()
            }
        }
    }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Create a new Post",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                },
                actions = {
                    TextButton(
                        onClick = {
                            coroutineScope.launch {
                                selectedImageUri?.let { uri ->
                                    val jpegByteArray =
                                        uriToJpegByteArray(context, uri, quality = 90)
                                    if (jpegByteArray != null) {
                                        viewModel.createPost(
                                            image = jpegByteArray,
                                            description = description
                                        )
                                    }
                                }
                            }
                        },
                        enabled = selectedImageUri != null && description.isNotBlank() && !isLoading,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )

                    ) {
                        Text(
                            text = "Publish",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        },

        bottomBar = {
            AppBottomNavigationBar(
                currentRoute = Routes.Post.id,
                onNavigateToFeed = { viewModel.onFeedNavigationRequested() },
                onNavigateToPost = { },
                onNavigateToProfile = { viewModel.onProfileNavigationRequested() }
            )
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 0.dp)
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error,
                )

                Spacer(modifier = Modifier.height(60.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(verticalAlignment = Alignment.Top) {
                AsyncImage(
                    model = uiState.user?.imageUrl ?: R.drawable.profile,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.scrim),
                    shape = MaterialTheme.shapes.extraSmall,
                    placeholder = {
                        Text(
                            text = "Write something...",
                            color = MaterialTheme.colorScheme.scrim.copy(alpha = 0.5f),
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            selectedImageUri?.let {
                AsyncImage(
                    model = it,
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(280.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            Button(
                onClick = { imagePickerLauncher.launch("image/*") }
                ,
                modifier = Modifier
                    .height(52.dp),
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Icon(Icons.Default.PhotoLibrary, contentDescription = "Select Image")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Select Image",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        if (isLoading) {
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