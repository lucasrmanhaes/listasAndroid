package com.lucas.listaslazy.repository

import com.lucas.listaslazy.model.Game

    fun getAllGames(): List<Game>{
        return  listOf(
            Game(id = 0, title = "Resident Evil 4", studio = "Capcom", releaseYear = 2005),
            Game(id = 1, title = "Grand Theft Auto San Andreas", studio = "Rockstar Games", releaseYear = 2004),
            Game(id = 2, title = "Silent Hill 2", studio = "Konami", releaseYear = 2001),
            Game(id = 3, title = "God of War", studio = "Sony", releaseYear = 2005),
            Game(id = 4, title = "God of War II", studio = "Sony", releaseYear = 2007),
            Game(id = 5, title = "Shadow of the Colossus", studio = "Sony", releaseYear = 2005),
            Game(id = 6, title = "Bully", studio = "Rockstar Games", releaseYear = 2006),
            Game(id = 7, title = "Kingdom Hearts", studio = "Square Enix", releaseYear = 2002),
            Game(id = 8, title = "Need For Speed Underground 2", studio = "Electronic Arts", releaseYear = 2004),
            Game(id = 9, title = "Black", studio = "Electronic Arts", releaseYear = 2006),
            Game(id = 10, title = "Twisted Metal Black", studio = "Sony", releaseYear = 2001),
            Game(id = 11, title = "Bomba patch 2013 100% atualizado", studio = "GeoMatrix", releaseYear = 2012),
        )
    }

    fun getGamesByStudio(nomeEstudio: String): List<Game>{
        return getAllGames().filter {
            it.studio.startsWith(prefix = nomeEstudio, ignoreCase = true)
        }
    }


