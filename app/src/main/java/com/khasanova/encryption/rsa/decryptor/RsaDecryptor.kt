package com.khasanova.encryption.rsa.decryptor

import com.khasanova.encryption.rsa.RSACipher
import com.khasanova.encryption.rsa.key.RSAKeyGeneration
import javax.crypto.Cipher

class RsaDecryptor(
    private val rsaKeyGeneration: RSAKeyGeneration,
    private val rsaCipher: RSACipher
) {

    fun decryptPhrase(privateKeyBytes: ByteArray, encryptedPhraseBytes: ByteArray): ByteArray {
        val privateKey = rsaKeyGeneration.generatePrivateKey(privateKeyBytes)

        val cipher = rsaCipher.initCipher(privateKey, Cipher.DECRYPT_MODE)

        return cipher.doFinal(encryptedPhraseBytes)
    }
}