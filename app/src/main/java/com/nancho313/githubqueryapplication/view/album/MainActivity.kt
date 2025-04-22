package com.nancho313.githubqueryapplication.view.album

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nancho313.githubqueryapplication.R
import com.nancho313.githubqueryapplication.model.repository.dto.Album
import com.nancho313.githubqueryapplication.viewmodel.album.ListAlbumViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val listAlbumViewModel: ListAlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contentList:RecyclerView = findViewById(R.id.contentList)
        contentList.layoutManager = LinearLayoutManager(this)

        val listOfAlbumObserver = Observer<List<Album>> { newAlbums ->

            contentList.adapter = ListAlbumAdapter(newAlbums)
        }
        listAlbumViewModel.albums.observe(this, listOfAlbumObserver)
        lifecycleScope.launch {

            listAlbumViewModel.loadAlbums()
        }
    }
}