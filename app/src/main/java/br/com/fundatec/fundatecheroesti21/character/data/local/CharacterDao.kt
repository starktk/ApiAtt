package br.com.fundatec.fundatecheroesti21.character.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert
    fun insertCharacter(characterEntity: CharacterEntity)

    @Query("SELECT * FROM characterTable")
    fun getCharacter(): List<CharacterEntity>


}