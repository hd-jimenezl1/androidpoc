package com.nancho313.githubqueryapplication.model.data.sqlite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.nancho313.githubqueryapplication.model.data.sqlite.entity.AlbumEntity

@Dao
interface AlbumDAO {

    @Query("SELECT * FROM album")
    fun getAll(): List<AlbumEntity>

    @Insert
    fun save(album: AlbumEntity)

    @Upsert
    fun saveAll(albums: List<AlbumEntity>)
}