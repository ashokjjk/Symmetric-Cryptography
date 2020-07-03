package uk.ac.ncl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;

import uk.ac.ncl.service.DecryptionService;
import uk.ac.ncl.service.EncryptionService;
import uk.ac.ncl.service.KeyService;

/**
 * @author AshokKumar
 * @author Airavati Subromonia
 * @apiNote Encryption and Decryption using symmetric cryptography
 * 
 */
public class Main {

	/**
	 * Keygeneration is the initial process from one active service
	 * {@link KeyGenerator}. Plain text is obtained from Resource folder. All data
	 * is read line by line using Scanner object and fed into
	 * {@link EncryptionService}. Once encryption is done then cipher text is fed
	 * into {@link DecryptionService}. Finally plain text is obtained.
	 */
	public static void main(String[] args) {
		System.out.println("Plain text can be fed in 'Resource/Plaintext file' ");
		System.out.println("---------------------------------------------------");
		try (Scanner scObj = new Scanner(new File("Resource/Plaintext.txt"))) {
			KeyService keyObj = new KeyService();
			keyObj.GenerateKey("i@am-the_Key", "I^am(Salt)");
			while (scObj.hasNext()) {
				EncryptionService encrypt = new EncryptionService();
				String cipherTxt = encrypt.EncrypText(scObj.nextLine(), keyObj);
				System.out.println("Cipher text: " + cipherTxt);

				DecryptionService decrypt = new DecryptionService();
				String plainTxt = decrypt.Decryption(cipherTxt, keyObj.getKey());
				System.out.println("Plain text: " + plainTxt);

				System.out.println("------------");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
