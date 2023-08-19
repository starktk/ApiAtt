package br.com.fundatec.fundatecheroesti21.character.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterModel
import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterResponse
import br.com.fundatec.fundatecheroesti21.database.FHdatabase
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

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
            try  {
                val response = client.criarPersonagem(id, characterRequest)
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("criar Personagem", exception.message.orEmpty())
                false
            }
        }
    }

    suspend fun getPersonagens(id: Int): List<CharacterModel> {
          return withContext(Dispatchers.IO) {
            try {
                val characterReturn = client.getPersonagens(id)
                if (characterReturn.isSuccessful){
                    characterReturn.body()?.mapperPersonagem() ?: emptyList()
                } else {
                    emptyList()
                }

            } catch (exception: Exception) {
                Log.e("listar personagem", exception.message.orEmpty())
                emptyList()
            }
        }
    }


    private fun List<CharacterResponse>.mapperPersonagem(): List<CharacterModel> {
        return map {
            it.characterResponseToCharacterModel()
        }
    }

    private fun CharacterResponse.characterResponseToCharacterModel(): CharacterModel {
        return CharacterModel(
            name = name,
            url = image
        )
    }
}