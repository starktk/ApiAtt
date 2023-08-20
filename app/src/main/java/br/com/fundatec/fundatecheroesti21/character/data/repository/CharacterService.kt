package br.com.fundatec.fundatecheroesti21.character.data.repository

import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface CharacterService {

    @POST("/api/character/{idUser}")
    suspend fun criarPersonagem(
        @Path("idUser") idUser:Int,
        @Body characterRequest: CharacterRequest
    ):Response<ResponseBody>

    @GET("/api/character/{idUser}")
    suspend fun getPersonagens(@Path("idUser") idUser: Int): Response<List<CharacterResponse>>

}