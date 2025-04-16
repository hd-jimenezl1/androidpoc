package com.nancho313.githubqueryapplication.view.album

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nancho313.githubqueryapplication.R
import com.nancho313.githubqueryapplication.model.repository.dto.Album

class ListAlbumAdapter(private val albums: List<Album>) :
    RecyclerView.Adapter<ListAlbumAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val author: TextView

        init {
            name = view.findViewById(R.id.name)
            author = view.findViewById(R.id.author)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.name.text = albums[position].name
        viewHolder.author.text = albums[position].author
        viewHolder.itemView.setOnClickListener {

            val intent = Intent(viewHolder.itemView.context, DetailAlbum::class.java)
            intent.putExtra("albumId", albums[position].id)
            viewHolder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = albums.size

}