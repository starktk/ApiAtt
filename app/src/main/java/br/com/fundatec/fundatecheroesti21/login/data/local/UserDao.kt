package br.com.fundatec.fundatecheroesti21.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT * from  userTable")
    fun getUser(): List<UserEntity>
}