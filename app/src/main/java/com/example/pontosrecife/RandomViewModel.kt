package com.example.pontosrecife

import androidx.lifecycle.ViewModel

class RandomViewModel : ViewModel() {

    var word = ""

    private lateinit var wordList: MutableList<String>

    private fun resetList() {
        wordList = mutableListOf(
                "Marco Zero",
                "Instituto Brennand",
                "Praia de Boa Viagem",
                "Rua da Moeda",
                "Centro de Artesanado de Pernambuco (Recife)"
        )
        wordList.shuffle()
    }

    init {
        resetList()
        nextWord()
    }

    fun onGenerate() {
        nextWord()
    }

    private fun nextWord() {
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }else {
            resetList()
            nextWord()
        }
    }
}