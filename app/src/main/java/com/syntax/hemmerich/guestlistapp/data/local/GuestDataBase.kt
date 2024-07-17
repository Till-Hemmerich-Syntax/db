package com.syntax.hemmerich.guestlistapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.syntax.hemmerich.guestlistapp.data.model.Guest

@Database(entities = [Guest::class], version = 1)
abstract class GuestDataBase : RoomDatabase() {
    abstract val dao : GuestDatabaseDAO
}
private lateinit var INSTANCE : GuestDataBase


fun getDataBase(context : Context) : GuestDataBase{
    synchronized(GuestDataBase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE= Room.databaseBuilder(
                context.applicationContext,
                GuestDataBase::class.java,
                "guestDB"
            ).build()
        }
        return INSTANCE
    }
}