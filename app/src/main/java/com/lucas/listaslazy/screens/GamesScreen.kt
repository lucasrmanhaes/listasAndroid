package com.lucas.listaslazy.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.listaslazy.repository.getAllGames

@Composable
fun GamesScreen(estudio: MutableState<String>){
    var item = remember { mutableStateOf(1) }

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
            value = estudio.value,
            onValueChange = {estudio.value = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do estúdio")
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(getAllGames()){
                Text(text = "Game: " + it.title)
                Text(text = "Estúdio: " + it.studio)
                Text(text = "Ano: " + it.releaseYear.toString())
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

    }
}