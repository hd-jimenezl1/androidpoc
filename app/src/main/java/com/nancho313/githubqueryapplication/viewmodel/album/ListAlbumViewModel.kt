package com.nancho313.githubqueryapplication.viewmodel.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nancho313.githubqueryapplication.model.repository.AlbumRepository
import com.nancho313.githubqueryapplication.model.repository.dto.Album

class ListAlbumViewModel: ViewModel() {

    val albums: MutableLiveData<List<Album>> by lazy {
        MutableLiveData()
    }

    private val repository: AlbumRepository = AlbumRepository()

    suspend fun loadAlbums() {

        albums.value = repository.getAlbums()
    }
}