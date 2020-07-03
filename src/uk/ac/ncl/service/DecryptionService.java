package uk.ac.ncl.service;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DecryptionService {

	public DecryptionService() {
		super();
		plainText = null;
	}

	private String plainText;

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	public String Decryption(String cipherText, SecretKey secretKey) {

		try {
			Cipher cipher = Cipher.getInstance("AES");

			Base64.Decoder decoder = Base64.getDecoder();

			byte[] encryptedTextByte = decoder.decode(cipherText);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedByte = cipher.doFinal(encryptedTextByte);

			plainText = new String(decryptedByte);

		} catch (Exception e) {
			System.out.println("Decryption exception : " + e.getMessage());
		}
		return plainText;
	}

}
