package com.nancho313.githubqueryapplication.viewmodel.album

import androidx.lifecycle.ViewModel
import com.nancho313.githubqueryapplication.model.repository.AlbumRepository
import com.nancho313.githubqueryapplication.model.repository.dto.Album

class DetailAlbumViewModel: ViewModel() {

    private val repository: AlbumRepository = AlbumRepository()

    private lateinit var album: Album

    suspend fun loadAlbum(albumId: Int) {

        album = repository.getAlbumById(albumId)
    }

    fun getAlbum(): Album {

        return album
    }
}