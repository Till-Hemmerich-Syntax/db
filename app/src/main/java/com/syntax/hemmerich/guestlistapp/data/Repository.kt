package com.syntax.hemmerich.guestlistapp.data

import androidx.lifecycle.LiveData
import com.syntax.hemmerich.guestlistapp.data.local.GuestDataBase
import com.syntax.hemmerich.guestlistapp.data.model.Guest

class Repository(private val dataBase : GuestDataBase) {

    val guestList: LiveData<List<Guest>> = dataBase.dao.getAll()

    suspend fun insert(guest: Guest){
        try {
        dataBase.dao.insert(guest)
        }catch(e : Exception){
            print(e)
        }
    }
    suspend fun update(guest: Guest){
        try {
            dataBase.dao.update(guest)
        }catch(e:Exception){
            print(e)
        }
    }
}