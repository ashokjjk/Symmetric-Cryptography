package uk.ac.ncl.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class KeyService {

	private SecretKey key;

	public KeyService() {
		super();
	}

	public SecretKey getKey() {
		return key;
	}

	public void setKey(SecretKey key) {
		this.key = key;
	}

	public void GenerateKey(String key, String salt) {
		SecretKey secret = null;
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			secret = new SecretKeySpec(tmp.getEncoded(), "AES");

		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		} catch (InvalidKeySpecException e) {
			System.out.println(e.getMessage());
		}
		setKey(secret);
	}

}
