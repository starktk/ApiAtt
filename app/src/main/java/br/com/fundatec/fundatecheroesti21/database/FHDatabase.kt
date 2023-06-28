package br.com.fundatec.fundatecheroesti21.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fundatec.fundatecheroesti21.App
import br.com.fundatec.fundatecheroesti21.login.data.local.UserDao
import br.com.fundatec.fundatecheroesti21.login.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2)
abstract class FHDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).allowMainThreadQueries().build()
        }
    }
}