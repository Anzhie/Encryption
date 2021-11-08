package com.khasanova.encryption.contracts

interface RsaEncryptionContract {

    fun getEncryptedPhrase(publicKeyBodyBase64: String, phrase: String): String?

    fun getDecryptedPhrase(privateKey: String, encryptedPhrase: String): String?
}