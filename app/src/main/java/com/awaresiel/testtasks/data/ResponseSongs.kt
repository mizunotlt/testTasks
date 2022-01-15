package com.awaresiel.testtasks.data
/*
     Example response from ItunesApi
    {
        resultCount : number,
        results : [
            {},
            {} ]
    }
 */
data class ResponseSongs(
    val resultCount: Int,
    val results: ArrayList<SongsData>
)