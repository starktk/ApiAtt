package br.com.fundatec.fundatecheroesti21.character.data.remote

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class CharacterResponse (
        val name: String,
        val description: String,
        val image: String,
        val universeType: String,
        val characterType: String,
        val age : Int,
//        val birthday: Date
)