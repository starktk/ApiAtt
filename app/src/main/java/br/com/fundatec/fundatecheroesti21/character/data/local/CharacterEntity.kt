package br.com.fundatec.fundatecheroesti21.character.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characterTable")
data class CharacterEntity (
        @PrimaryKey(autoGenerate = true)
        val name: String,
        val description: String,
        val image: String,
        val universeType: String,
        val heroType: String,
        val age: Int,
        val dataAniver: String
        )