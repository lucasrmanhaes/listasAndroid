package com.lucas.listaslazy.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.listaslazy.components.GameCard
import com.lucas.listaslazy.components.StudioCard
import com.lucas.listaslazy.model.Game
import com.lucas.listaslazy.repository.getAllGames
import com.lucas.listaslazy.repository.getGamesByStudio

@Composable
fun GamesScreen(estudioState: MutableState<String>, listStudioState: MutableState<List<Game>>){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Meus jogos favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = estudioState.value,
            onValueChange = {
                estudioState.value = it
                listStudioState.value = getGamesByStudio(estudioState.value)
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do estúdio")
            },
            trailingIcon = {
                IconButton(
                    onClick = { listStudioState.value = getGamesByStudio(estudioState.value) }
                )
                {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(getAllGames()) {
                StudioCard(game = it)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(listStudioState.value){
                GameCard(game = it)
            }
        }

    }
}