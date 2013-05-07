package br.com.htk.taoks.crypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class TAOFSMethods {
	
	private static final String DEFAULT_PASSPHRASE = "XXxxxxxxxxxxxxXX";
	
	
	public static String Encrypt(String strToBeEncrypted){
		String encryptedString = null;
		byte[] encryptedPassword = null;
		SecretKeySpec secretkey = new SecretKeySpec(DEFAULT_PASSPHRASE.getBytes(), "Blowfish");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, secretkey);
			encryptedPassword =  cipher.doFinal(strToBeEncrypted.getBytes());
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		encryptedString = new String(encryptedPassword);
		return encryptedString;
	}
	
	public static String Decrypt(String strToBeDecrypted){
		String encryptedString = null;
		byte[] encryptedPassword = null;
		SecretKeySpec secretkey = new SecretKeySpec(DEFAULT_PASSPHRASE.getBytes(), "Blowfish");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, secretkey);
			encryptedPassword =  cipher.doFinal(strToBeDecrypted.getBytes());
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		encryptedString = new String(encryptedPassword);
		return encryptedString;
	}

}
