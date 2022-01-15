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
data class ResponseAlbums (
    val resultCount: Int,
    val results: ArrayList<AlbumsData>
)