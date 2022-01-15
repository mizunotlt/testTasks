package com.awaresiel.testtasks.repository

import com.awaresiel.testtasks.api.AlbumsApi
import com.awaresiel.testtasks.data.AlbumsData
import com.awaresiel.testtasks.utils.Constants

open class AlbumsRepository (private val apiAl: AlbumsApi): BaseRepository() {

    /*
        Function for getting album from api iTunes
        Search request
        Function is suspending
     */

    suspend fun getAlbumsListByTerm(term: String, offset: Int): ArrayList<AlbumsData>?{
        val albumResponse = safeApiCall(
            call = { apiAl.getAlbumsAsync(term,"US", "music", "album","albumTerm", Constants.LIMIT, offset).await()},
            errorMessage = "Error Getting albums from api"
        )
        return albumResponse?.results
    }

}