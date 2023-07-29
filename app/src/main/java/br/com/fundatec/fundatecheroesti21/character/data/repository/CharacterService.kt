package br.com.fundatec.fundatecheroesti21.character.data.repository

import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterResponse
import retrofit2.Response
import retrofit2.http.*

interface CharacterService {

    @POST("api/character/{id}")
    suspend fun criarPersonagem(
        @Path("id") id: Int,
        @Body characterRequest: CharacterRequest
    ): Response<CharacterRequest>

    @GET("api/character/{id}")
    suspend fun getPersonagens(@Path ("id") id: Int): Response<CharacterResponse>

    @DELETE("api/transaction/{id}")
    suspend fun deletarPersonagem(@Path ("id") id: Int)
}