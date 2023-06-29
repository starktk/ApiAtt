package br.com.fundatec.fundatecheroesti21.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fundatec.fundatecheroesti21.App
import br.com.fundatec.fundatecheroesti21.login.data.local.UserDao
import br.com.fundatec.fundatecheroesti21.login.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2)
abstract class FHdatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHdatabase {
            return Room.databaseBuilder(
                App.context,
                FHdatabase::class.java,
                "fh.database"
            ).allowMainThreadQueries().build()
        }
    }
}