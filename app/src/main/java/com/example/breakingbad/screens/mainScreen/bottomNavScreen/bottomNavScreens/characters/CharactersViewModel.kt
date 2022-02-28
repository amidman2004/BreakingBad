package com.example.breakingbad.screens.mainScreen.bottomNavScreen.bottomNavScreens.characters

import androidx.lifecycle.ViewModel
import com.example.breakingbad.domain.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val api:ApiRepository
    ):ViewModel(){
        
}