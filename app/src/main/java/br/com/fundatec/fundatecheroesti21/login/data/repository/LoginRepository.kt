package br.com.fundatec.fundatecheroesti21.login.data.repository;

import android.util.Log
import br.com.fundatec.fundatecheroesti21.database.FHdatabase
import br.com.fundatec.fundatecheroesti21.login.data.local.UserEntity
import br.com.fundatec.fundatecheroesti21.login.data.remote.LoginResponse
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.util.Date

class
LoginRepository {
    private val database: FHdatabase by lazy {
        FHdatabase.getInstance()
    }

    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(LoginService::class.java)

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getUser(email, password)
                saveUser(response)
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }

        }
    }
    suspend fun validateCache(isTimeMaior: Boolean) {
        val user = database.userDao().getUser()
        val dataCache = database.userDao().getCache().time
        val dataHoje = Date().time
        val diff = dataHoje - dataCache
        val seconds = diff / 1000
        val minutes = seconds / 60
        if (minutes > 10) {
            cleanReuse(user, isTimeMaior)
        }
    }

    private suspend fun cleanReuse(user: Response<LoginResponse>, isTimeMenor: Boolean): Boolean {
        database.userDao().deletarCache()
        return !isTimeMenor;
    }
    private suspend fun saveUser(user: Response<LoginResponse>) {
        return withContext(Dispatchers.IO) {
            if (user.isSuccessful) {
                user.body()?.run {
                    database.userDao().insertUser(
                        userResponseToEntity()
                    )
                }
            }
        }
    }

    private fun LoginResponse.userResponseToEntity(): UserEntity {
        return UserEntity(
            name = name,
            email = email,
            password = password,
            dataLog = Date()
        )
    }
}