package com.example.muntilingualer

class CsvData {
    private lateinit var id: String
    private lateinit var word: String
    private lateinit var pronunciation: String

    fun setId(id: String) {
        this.id = id
    }

    fun getId(): String {
        return this.id
    }

    fun setWord(word: String) {
        this.word = word
    }

    fun getWord(): String {
        return this.word
    }

    fun setPronunciation(pronunciation: String) {
        this.pronunciation = pronunciation
    }

    fun getPronunciation(): String {
        return this.pronunciation
    }
}