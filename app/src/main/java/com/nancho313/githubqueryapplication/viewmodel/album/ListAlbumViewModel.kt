package com.nancho313.githubqueryapplication.viewmodel.album

import androidx.lifecycle.ViewModel
import com.nancho313.githubqueryapplication.model.repository.AlbumRepository
import com.nancho313.githubqueryapplication.model.repository.dto.Album

class ListAlbumViewModel: ViewModel() {

    private val repository: AlbumRepository = AlbumRepository()

    private var albums:MutableList<Album> = mutableListOf()

    suspend fun loadAlbums() {

        albums.clear()
        albums.addAll(repository.getAlbums())
    }

    fun getAlbums(): List<Album> {

        return albums
    }

}