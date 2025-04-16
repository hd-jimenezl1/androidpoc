package com.nancho313.githubqueryapplication.model.data.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nancho313.githubqueryapplication.model.data.sqlite.dao.AlbumDAO
import com.nancho313.githubqueryapplication.model.data.sqlite.entity.AlbumEntity

@Database(entities = [AlbumEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun albumDAO(): AlbumDAO
}