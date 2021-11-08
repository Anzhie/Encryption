package com.khasanova.encryption.rsa

import java.security.Key
import javax.crypto.Cipher

/*
Transformation detailed description here
https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Cipher
*/
private const val TRANSFORMATION = "RSA/ECB/PKCS1Padding"

class RSACipher {

    fun initCipher(key: Key, mode: Int): Cipher {
        var cipher = Cipher.getInstance(TRANSFORMATION)

        cipher.init(mode, key)

        return cipher
    }
}