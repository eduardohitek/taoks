/**
 *
 */
package br.com.htk.taoks.crypt.test;

import br.com.htk.taoks.crypt.TAOFSMethods;

/**
 * @author ehenrique
 *
 */
public class MainTest {

	public static void main(String[] args) {
		String str = "tlaokas";
		String enc = TAOFSMethods.Encrypt(str);
		System.out.println(enc);
		String dec = TAOFSMethods.Decrypt(enc);
		System.out.println(dec);
	}

}
