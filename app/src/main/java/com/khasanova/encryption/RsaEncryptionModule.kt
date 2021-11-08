package com.khasanova.encryption

import com.khasanova.encryption.contracts.RsaEncryptionContract
import com.khasanova.encryption.di.Factory

class RsaEncryptionModule {

    private val rsaEncryption: RsaEncryptionContract =
        Factory
            .createRsaEncryptionFactory()
            .createRsaEncryption()

    fun getEncryptedPhrase(publicKeyBodyBase64: String, phrase: String) =
        rsaEncryption.getEncryptedPhrase(publicKeyBodyBase64, phrase)

    fun getDecryptedPhrase(privateKey: String, encryptedPhrase: String) =
        rsaEncryption.getDecryptedPhrase(privateKey, encryptedPhrase)
}