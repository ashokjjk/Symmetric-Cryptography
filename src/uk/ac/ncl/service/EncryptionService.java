package uk.ac.ncl.service;

import java.util.Base64;

import javax.crypto.Cipher;

public class EncryptionService {

	private String cipherText;

	public EncryptionService() {
		super();
		cipherText = null;
	}

	public String getCipherText() {
		return cipherText;
	}

	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}

	public String EncrypText(String plainTxt, KeyService keyObj) {

		try {
			Cipher cipher = Cipher.getInstance("AES");
			byte[] plainTextByte = plainTxt.getBytes();
			cipher.init(Cipher.ENCRYPT_MODE, keyObj.getKey());
			byte[] encryptedByte = cipher.doFinal(plainTextByte);
			Base64.Encoder encoder = Base64.getEncoder();
			cipherText = encoder.encodeToString(encryptedByte);
		} catch (Exception e) {
			System.out.println("Encryption exception: " + e.getMessage());
		}
		return cipherText;
	}

}
