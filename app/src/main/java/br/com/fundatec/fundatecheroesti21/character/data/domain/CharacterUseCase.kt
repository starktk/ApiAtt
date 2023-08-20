package br.com.fundatec.fundatecheroesti21.character.data.domain

import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterModel
import br.com.fundatec.fundatecheroesti21.character.data.repository.CharacterRepository
import br.com.fundatec.fundatecheroesti21.character.data.repository.CharacterRequest
import br.com.fundatec.fundatecheroesti21.login.domain.LoginUseCase

class CharacterUseCase {

    private val characterRepository by lazy {
        CharacterRepository()
    }
    private val loginUsecase by lazy { LoginUseCase() }

    suspend fun getReferenceUser(): Int {
        return loginUsecase.getIdUser()
    }
    suspend fun adicionarPersonagem(name: String, description: String, age: Int, birth_date: String,
                                    select_heroType: String, select_univerType: String, url_image: String): Boolean {
        val id = getReferenceUser()
        val characterRequest: CharacterRequest = convert(name, description, age, birth_date,
            select_heroType, select_univerType, url_image)
        return characterRepository.addPersonagem(id, characterRequest)
    }
    private fun convert(name: String, description: String,
                        age: Int, birth_date: String, select_heroType: String,
                        select_univerType: String, url_image: String): CharacterRequest {
        return CharacterRequest(
            name,
            description,
            url_image,
            select_univerType,
            select_heroType,
            age,
            birth_date)
    }
    suspend fun pegarPersonagem(): List<CharacterModel> {
        val id = getReferenceUser()
        return characterRepository.getPersonagens(id)
    }
}