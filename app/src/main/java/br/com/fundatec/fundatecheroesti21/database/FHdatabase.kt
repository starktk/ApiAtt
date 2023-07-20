package br.com.fundatec.fundatecheroesti21.database

import androidx.room.*
import br.com.fundatec.fundatecheroesti21.App
import br.com.fundatec.fundatecheroesti21.database.converters.Converter
import br.com.fundatec.fundatecheroesti21.login.data.local.UserDao
import br.com.fundatec.fundatecheroesti21.login.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converter::class)
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