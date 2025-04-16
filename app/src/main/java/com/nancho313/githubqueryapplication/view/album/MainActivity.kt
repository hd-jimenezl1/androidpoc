package com.nancho313.githubqueryapplication.view.album

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nancho313.githubqueryapplication.R
import com.nancho313.githubqueryapplication.viewmodel.album.ListAlbumViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val contentList:RecyclerView = findViewById(R.id.contentList)
        contentList.layoutManager = LinearLayoutManager(this)
        val listAlbumViewModel: ListAlbumViewModel by viewModels()
        lifecycleScope.launch {

            listAlbumViewModel.loadAlbums()
            contentList.adapter = ListAlbumAdapter(listAlbumViewModel.getAlbums())
        }
    }
}