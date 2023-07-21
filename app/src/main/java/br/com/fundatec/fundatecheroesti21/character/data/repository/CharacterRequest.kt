package br.com.fundatec.fundatecheroesti21.character.data.repository

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class CharacterRequest (
    val name: String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age : Int,
    val birthday: String,
)