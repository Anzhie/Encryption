package com.khasanova.encryption.rsa.encryptor

import com.khasanova.encryption.rsa.RSACipher
import com.khasanova.encryption.rsa.key.RSAKeyGeneration
import javax.crypto.Cipher

class RsaEncryptor(
    private val rsaKeyGeneration: RSAKeyGeneration,
    private val rsaCipher: RSACipher
) {

    fun encryptPhrase(publicKeyBytes: ByteArray, phraseBytes: ByteArray): ByteArray {
        val publicKey = rsaKeyGeneration.generatePublicKey(publicKeyBytes)

        val cipher = rsaCipher.initCipher(publicKey, Cipher.ENCRYPT_MODE)

        return cipher.doFinal(phraseBytes)
    }
}