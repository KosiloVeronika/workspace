package com.epam.libraryManager.hashPassword;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.epam.libraryManager.dao.DaoException;
import com.epam.libraryManager.resource.ConfigurationManager;

public class HashPassword {

	public HashPassword() {
	}

	public String hashPasswordWithSalt(String password, byte[] salt) throws DaoException {
		password += ConfigurationManager.getProperty("crypt.localParameter");
		PBEKeySpec pbe = new PBEKeySpec(password.toCharArray(), salt, 4096, 1024);
		byte[] keyArray;
		try {
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			SecretKey key = secretKeyFactory.generateSecret(pbe);
			keyArray = key.getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new DaoException(e);
		} 
		return new String(keyArray);
	}
	
	public byte[] makeSalt() {
		Random random = new Random();
		int saltLength = 12 + random.nextInt(6); 
		byte[] salt = new byte[saltLength];
		random.nextBytes(salt);
		return salt;
	}
}
