package com.nancho313.githubqueryapplication.view.album

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.nancho313.githubqueryapplication.R
import com.nancho313.githubqueryapplication.viewmodel.album.DetailAlbumViewModel
import com.nancho313.githubqueryapplication.viewmodel.album.ListAlbumViewModel
import kotlinx.coroutines.launch

class DetailAlbum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_album)
    }

    override fun onStart() {
        super.onStart()
        val albumId = intent.getIntExtra("albumId", -1)
        val detailAlbumViewModel: DetailAlbumViewModel by viewModels()
        lifecycleScope.launch {

            detailAlbumViewModel.loadAlbum(albumId)
            val albumName = findViewById<TextView>(R.id.detailAlbumName)
            val albumDescription = findViewById<TextView>(R.id.detailAlbumDescription)

            albumName.text = detailAlbumViewModel.getAlbum().name
            albumDescription.text = detailAlbumViewModel.getAlbum().description
        }
    }
}