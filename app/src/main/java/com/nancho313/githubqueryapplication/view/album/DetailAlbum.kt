package com.nancho313.githubqueryapplication.view.album

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.nancho313.githubqueryapplication.R
import com.nancho313.githubqueryapplication.model.repository.dto.Album
import com.nancho313.githubqueryapplication.viewmodel.album.DetailAlbumViewModel
import kotlinx.coroutines.launch

class DetailAlbum : AppCompatActivity() {

    private val detailAlbumViewModel: DetailAlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_album)
        val albumName = findViewById<TextView>(R.id.detailAlbumName)
        val albumDescription = findViewById<TextView>(R.id.detailAlbumDescription)
        val albumObserver = Observer<Album> { newAlbum ->

            albumName.text = newAlbum.name
            albumDescription.text = newAlbum.description
        }
        detailAlbumViewModel.album.observe(this, albumObserver)
    }

    override fun onStart() {
        super.onStart()
        val albumId = intent.getIntExtra("albumId", -1)
        lifecycleScope.launch {

            detailAlbumViewModel.loadAlbum(albumId)
        }
    }
}