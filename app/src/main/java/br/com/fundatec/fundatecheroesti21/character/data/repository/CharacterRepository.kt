package br.com.fundatec.fundatecheroesti21.character.data.repository

import br.com.fundatec.fundatecheroesti21.database.FHdatabase
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository {

    private val database: FHdatabase by lazy {
        FHdatabase.getInstance()
    }

    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(CharacterService::class.java)


    suspend fun addPersonagem(id: Int, characterRequest: CharacterRequest): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.criarPersonagem(id, characterRequest)
            response.isSuccessful
        }
    }
}