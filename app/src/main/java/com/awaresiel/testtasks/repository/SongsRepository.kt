package com.awaresiel.testtasks.repository

import com.awaresiel.testtasks.api.SongsApi
import com.awaresiel.testtasks.data.SongsData

class SongsRepository (private val api: SongsApi): BaseRepository(){
    /*
        Function for getting songs from api iTunes
        lookup request
        Function is suspending
     */
    suspend fun getSongsList(id: Int): ArrayList<SongsData>?{
        val songsResponse = safeApiCall(
            call = { api.getSongsAsync(id,"song").await()},
            errorMessage = "Error Getting songs from api"
        )
        return songsResponse?.results
    }
}