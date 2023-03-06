package com.hos.mager.numberfacts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hos.mager.numberfacts.data.room.MathFact
import com.hos.mager.numberfacts.domain.userCase.GetMathFactUseCase
import com.hos.mager.numberfacts.domain.userCase.MathFactUserCase
import kotlinx.coroutines.launch

class MathFactViewModel : ViewModel() {

    suspend fun getMathFact(number: Int, getMathFactUseCase: GetMathFactUseCase): String {
        return getMathFactUseCase.invoke(number)
    }

    suspend fun getMathFact(getMathFactUseCase: GetMathFactUseCase): String {
        return getMathFactUseCase.invoke()
    }

    suspend fun save(save:String,mathFactUseCase: MathFactUserCase){
        mathFactUseCase.exe(save)
    }

    suspend fun getSave(mathFactUseCase: MathFactUserCase):List<MathFact>{
        return mathFactUseCase.exe()
    }
}