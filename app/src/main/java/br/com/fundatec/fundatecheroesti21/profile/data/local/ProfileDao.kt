package br.com.fundatec.fundatecheroesti21.profile.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ProfileDao {

    @Insert
    fun insertProfile(profileEntity: ProfileEntity)
}