package com.khasanova.encryption.rsa

import android.util.Base64
import android.util.Log
import com.khasanova.encryption.contracts.RsaEncryptionContract
import com.khasanova.encryption.rsa.decryptor.RsaDecryptor
import com.khasanova.encryption.rsa.encryptor.RsaEncryptor

private const val BASE_64_FLAGS = Base64.NO_WRAP
private const val RSA_ENCRYPTION_ERROR = "RSA_ENCRYPTION_ERROR"
private const val RSA_DECRYPTION_ERROR = "RSA_DECRYPTION_ERROR"

internal class RSAEncryption(
    private val rsaEncryptor: RsaEncryptor,
    private val rsaDecryptor: RsaDecryptor
) : RsaEncryptionContract {

    override fun getEncryptedPhrase(publicKeyBodyBase64: String, phrase: String): String? {
        return try {
            val phraseBytes = phrase.toByteArray()
            val publicKeyBytes = Base64.decode(publicKeyBodyBase64, BASE_64_FLAGS)

            val encryptedPhraseBytes = rsaEncryptor.encryptPhrase(publicKeyBytes, phraseBytes)

            Base64.encodeToString(encryptedPhraseBytes, BASE_64_FLAGS)
        } catch (e: Exception) {
            Log.d(RSA_ENCRYPTION_ERROR, e.message.orEmpty())
            null
        }
    }

    override fun getDecryptedPhrase(privateKey: String, encryptedPhrase: String): String? {
        return try {
            val encryptedPhraseBytes = Base64.decode(encryptedPhrase, BASE_64_FLAGS)
            val privateKeyBytes = Base64.decode(privateKey, BASE_64_FLAGS)

            val decryptedPhraseBytes = rsaDecryptor.decryptPhrase(privateKeyBytes, encryptedPhraseBytes)

            decryptedPhraseBytes.toString(Charsets.UTF_8)
        } catch (e: Exception) {
            Log.d(RSA_DECRYPTION_ERROR, e.message.orEmpty())
            null
        }
    }
}