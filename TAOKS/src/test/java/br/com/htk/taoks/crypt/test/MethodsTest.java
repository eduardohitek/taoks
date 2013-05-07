package br.com.htk.taoks.crypt.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.htk.taoks.crypt.TAOFSMethods;

public class MethodsTest {



	@Test
	public void testEncrypt() {
		String ret = TAOFSMethods.Encrypt("tlaokas");
		assertEquals("q]�J/��5", ret);
	}

	@Test
	public void testDecrypt() {
		String ret = TAOFSMethods.Decrypt("q]�J/��5");
		assertEquals("tlaokas", ret);
	}

}
