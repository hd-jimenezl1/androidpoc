package com.nancho313.githubqueryapplication.model.repository

import com.nancho313.githubqueryapplication.MainApplication
import com.nancho313.githubqueryapplication.model.data.rest.serviceadapters.AlbumServiceAdapter
import com.nancho313.githubqueryapplication.model.data.sqlite.dao.AlbumDAO
import com.nancho313.githubqueryapplication.model.data.sqlite.entity.AlbumEntity
import com.nancho313.githubqueryapplication.model.repository.dto.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumRepository {

    private val albumServiceAdapter: AlbumServiceAdapter =
        AlbumServiceAdapter("http://192.168.20.6:3000/")

    private val albumDAO: AlbumDAO = MainApplication.database.albumDAO();

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
        val albumToInsert = AlbumEntity(albumFromService.id, albumFromService.name, albumFromService.description)
        withContext(Dispatchers.IO) {

            albumDAO.save(albumToInsert)
        }
        return Album(
            albumFromService.id,
            albumFromService.performers[0].name,
            albumFromService.name,
            albumFromService.description
        )
    }

//    private fun getAlbumDao():AlbumDAO {
//
//        if(albumDAO === null) {
//
//            albumDAO = MainApplication.database.albumDAO()
//        }
//        return albumDAO as AlbumDAO
//    }
}