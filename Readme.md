### Symmetric Cryptography - Java
1. Uses crypto library from Javax.
2. Secret key is generated and delivered as a service to next process.
3. Genereted key is 256 bit with AES encryption standard using <b>'PBKDF2WithHmacSHA256'</b>.
4. To provide additional security 'salt' value is also provided to key value.
5. Encryption service get the secret key from keygen service for each encryption.
6. After encryption the cipher text is fed into decryption service to obtain plain text.
7. For persistance plain text, secret key and ciphertext has to be stored in DB for further processing.

<h3>Project</h3>
Dissertation on cryptography
<h3> Credits</h3>
Airavati Subromonia, Ashok kumar
