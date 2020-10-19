package com.example.preparation2020

class EncryptionUtils {

    class EncryptionUtilsHolder {
        companion object {
            val sInstance = EncryptionUtils()
        }
    }

    fun getInstance(): EncryptionUtils {
        return EncryptionUtilsHolder.sInstance
    }


    fun getName() = "Sukumar"
}