package com.khasanova.encryption.di

import com.khasanova.encryption.contracts.RsaEncryptionContract

abstract class Factory {

    abstract fun createRsaEncryption(): RsaEncryptionContract

    companion object {
        fun createRsaEncryptionFactory(): Factory = RSAEncryptionFactory()
    }
}