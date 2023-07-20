package br.com.fundatec.fundatecheroesti21.login.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fundatec.fundatecheroesti21.login.data.remote.LoginResponse
import retrofit2.Response
import java.util.*

@Dao
interface UserDao {

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT dataLog FROM userTable")
    fun getCache(): Date

    @Query("SELECT * FROM userTable")
    fun getUser(): List<UserEntity>

    @Query("SELECT id FROM userTable")
    fun getId(): Int

    @Query("DELETE  FROM userTable ")
    fun deletarCache()
}