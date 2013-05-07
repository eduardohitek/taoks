package br.com.htk.taoks.crypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Methods {

	private MethodsProperties properties;

	public Methods(MethodsProperties properties){
		this.properties = properties;
	}

	public String encrypt(String strToBeEncrypted) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		String encryptedString = executeOperation(Cipher.ENCRYPT_MODE, strToBeEncrypted);
		return encryptedString;
	}

	public String decrypt(String strToBeDecrypted) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		String encryptedString = executeOperation(Cipher.DECRYPT_MODE, strToBeDecrypted);
		return encryptedString;
	}

	private String executeOperation(int cipherMode, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		String ret = null;
		byte[] retArray = null;
		SecretKeySpec secretkey = new SecretKeySpec(properties.getDEFAULT_PASSPHRASE().getBytes(), properties.getAlgorithm());
		Cipher cipher;
			cipher = Cipher.getInstance(properties.getTransformation());
			cipher.init(cipherMode, secretkey);
			retArray =  cipher.doFinal(str.getBytes());

		ret = new String(retArray);
		return ret;
	}

}
