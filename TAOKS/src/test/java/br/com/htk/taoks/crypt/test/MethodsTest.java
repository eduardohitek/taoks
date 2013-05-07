package br.com.htk.taoks.crypt.test;

import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.htk.taoks.crypt.Methods;
import br.com.htk.taoks.crypt.MethodsProperties;

@RunWith(MockitoJUnitRunner.class)
public class MethodsTest {

	@Spy
	private MethodsProperties properties;

	private Methods methods;

	@Before
	public void setUp(){
		methods = new Methods(properties);
	}

	@Test
	public void shouldEncrypt() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String ret = methods.encrypt("tlaokas");
		assertEquals("q]�J/��5", ret);
	}

	@Test
	public void shouldDecrypt() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String ret = methods.decrypt("q]�J/��5");
		assertEquals("tlaokas", ret);
	}

}
