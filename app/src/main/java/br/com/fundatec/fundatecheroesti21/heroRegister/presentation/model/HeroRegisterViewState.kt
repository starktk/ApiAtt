package br.com.fundatec.fundatecheroesti21.heroRegister.presentation.model

sealed class HeroRegisterViewState {
    object ShowHomeScreen : HeroRegisterViewState()
    object ShowLoading : HeroRegisterViewState()
    object ShowNameError : HeroRegisterViewState()
    object ShowDescriptionError : HeroRegisterViewState()
    object ShowMessageError : HeroRegisterViewState()
    object ShowAgeError : HeroRegisterViewState()
    object ShowBirthDateError : HeroRegisterViewState()
    object ShowUrlImageError : HeroRegisterViewState()
    object ShowSelectHeroTypeError : HeroRegisterViewState()
    object ShowSelectUniverseTypeError : HeroRegisterViewState()
    object ShowActionError : HeroRegisterViewState()
}