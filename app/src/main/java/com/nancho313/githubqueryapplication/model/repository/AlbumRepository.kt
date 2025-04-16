package com.nancho313.githubqueryapplication.model.repository

import com.nancho313.githubqueryapplication.model.data.rest.serviceadapters.AlbumServiceAdapter
import com.nancho313.githubqueryapplication.model.repository.dto.Album

class AlbumRepository {

    private val albumServiceAdapter: AlbumServiceAdapter =
        AlbumServiceAdapter("http://192.168.20.6:3000/")

    suspend fun getAlbums(): List<Album> {

        val result: MutableList<Album> = mutableListOf()
        val albumsFromService = albumServiceAdapter.getAllAlbums()
        albumsFromService.forEach { albumResponse ->
            result.add(
                Album(
                    albumResponse.id,
                    albumResponse.performers[0].name,
                    albumResponse.name,
                    albumResponse.description
                )
            )
        }
        return result
    }

    suspend fun getAlbumById(albumId: Int): Album {

        val albumFromService = albumServiceAdapter.getAlbumById(albumId)
        return Album(
            albumFromService.id,
            albumFromService.performers[0].name,
            albumFromService.name,
            albumFromService.description
        )
    }
}