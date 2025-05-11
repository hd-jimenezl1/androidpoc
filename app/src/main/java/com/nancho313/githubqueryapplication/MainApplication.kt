package com.nancho313.githubqueryapplication

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.nancho313.githubqueryapplication.model.data.sqlite.AppDatabase
import kotlin.math.log

class MainApplication : Application() {

    companion object {

        lateinit var database:AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Tag", "The application was initialized ----------------------------------")
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "exampleDatabase").build()
    }
}