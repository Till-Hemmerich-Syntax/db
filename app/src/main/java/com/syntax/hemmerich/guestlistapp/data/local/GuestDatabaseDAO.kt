package com.syntax.hemmerich.guestlistapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.syntax.hemmerich.guestlistapp.data.model.Guest

@Dao
interface GuestDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(guest: Guest)

    @Update
    suspend fun update(guest: Guest)

    @Query("SELECT * FROM GUEST")
    fun getAll(): LiveData<List<Guest>>

}