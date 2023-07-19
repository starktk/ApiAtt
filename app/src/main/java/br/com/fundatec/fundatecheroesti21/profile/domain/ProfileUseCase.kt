package br.com.fundatec.fundatecheroesti21.profile.domain

import br.com.fundatec.fundatecheroesti21.profile.data.repository.ProfileRepository

class ProfileUseCase {

    private val repository by lazy { ProfileRepository() }


}