package com.khasanova.encryption.di

import com.khasanova.encryption.contracts.RsaEncryptionContract
import com.khasanova.encryption.rsa.RSACipher
import com.khasanova.encryption.rsa.RSAEncryption
import com.khasanova.encryption.rsa.decryptor.RsaDecryptor
import com.khasanova.encryption.rsa.encryptor.RsaEncryptor
import com.khasanova.encryption.rsa.key.RSAKeyGeneration

class RSAEncryptionFactory: Factory() {

    override fun createRsaEncryption(): RsaEncryptionContract {
        val rsaKeyGeneration = RSAKeyGeneration()
        val rsaCipher = RSACipher()

        val rsaEncryptor = RsaEncryptor(rsaKeyGeneration, rsaCipher)
        val rsaDecryptor = RsaDecryptor(rsaKeyGeneration, rsaCipher)

        return RSAEncryption(rsaEncryptor, rsaDecryptor)
    }
}