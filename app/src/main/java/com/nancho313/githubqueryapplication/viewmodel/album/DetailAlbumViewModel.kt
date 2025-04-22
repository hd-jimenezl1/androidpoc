package com.nancho313.githubqueryapplication.viewmodel.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nancho313.githubqueryapplication.model.repository.AlbumRepository
import com.nancho313.githubqueryapplication.model.repository.dto.Album

class DetailAlbumViewModel: ViewModel() {

    private val repository: AlbumRepository = AlbumRepository()

    val album: MutableLiveData<Album> by lazy {
        MutableLiveData<Album>()
    }

    suspend fun loadAlbum(albumId: Int) {

        album.value = repository.getAlbumById(albumId)
    }
}