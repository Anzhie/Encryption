package com.khasanova.encryption.rsa.key

import java.security.KeyFactory
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

private const val ALGORITHM = "RSA"

class RSAKeyGeneration {

    fun generatePublicKey(publicKeyBodyBytes: ByteArray): PublicKey {
        val publicKeySpecs = X509EncodedKeySpec(publicKeyBodyBytes)

        val keyFactory = KeyFactory.getInstance(ALGORITHM)

        return keyFactory.generatePublic(publicKeySpecs)
    }

    fun generatePrivateKey(privateKeyBytes: ByteArray): PrivateKey {
        val privateKeySpecs = PKCS8EncodedKeySpec(privateKeyBytes)

        val keyFactory = KeyFactory.getInstance(ALGORITHM)
        return keyFactory.generatePrivate(privateKeySpecs)
    }
}