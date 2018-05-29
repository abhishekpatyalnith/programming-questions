import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Test {

	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void main(String[] args) {

		String xml = "<loanRequest><firstName>AJIT SUDHAKAR</firstName><lastName>KASAR</lastName><mobileNumber>9100966627</mobileNumber><panNumber>AGZPK1371M</panNumber><email>awasthirahul88@gmail.com</email><dob>14041972</dob><gender>1</gender><loanAmount>100000</loanAmount><addrLine1>ICICI</addrLine1><addrLine2>ICICI</addrLine2><state>Chhattisgarh</state><city>ICICI</city><addressType>PA</addressType><postal>560030</postal><addrLine21>ICICI</addrLine21><addrLine22>ICICI</addrLine22><state2>ICICI</state2><city2>ICICI</city2><addressType2>CA</addressType2><postal2>560030</postal2><averageMonthlyTransaction6months>36486</averageMonthlyTransaction6months><iBankCustomer>YES</iBankCustomer><customerType1>A</customerType1></loanRequest>";

		System.out.println(xml);

		// EPAYLATER
	//	String encrypt = encrypt(xml, "ffe9c13fb6034367a32613779ff7d8c8");

		// PAYTM
		 String encrypt = encrypt(xml, "77790f7eb4244c6a867788df8645700f");

		// Pockets
		// String encrypt = AES.encrypt(xml,
		// "fc71e732e60d4d6695bec315d2e1113f");
		//
		// String encrypt =
		// "yDTkwrJi8a7ko8fDqLdEl1mc0gCFCfwRCPTVvfHzTFT1HaOYo/MD+xW72FpfkQvkayY9MNJfCNoPF+blycdoD1dDwqANF+ke+WPbci7yUHcgEiK+WIrU0PxT6MKSqcWJZgUXik/GX2Qff8yRMnskn2oYB83l7qskaMbpOFMgrAZB/dcokbnG6c7WpaqCSbqyd4TsJsYr6QRBvs27vbRc37MgPNPYnL/wz635ts3JSWDav2G5OaO9mY5XXR7mFIL6oHwvG8snkSZ8l+OxC1BNmiOVnXl6BrAKnUAYfp9XwVgXSIFBEM5HzDTcAI1EbttjBGjzxeTNAd/U/S7oIqctg9x1fCRWNN/RLOAgtx3NcuFZImod7hsCkizEdYY/kgSksqOWhjfY+NUHKJBwGurxm6K6P+ue/xXCe/CFPQXiANEHEpuDiYgVVP/1EhOs4cc55og0UMZ5j8XONSNY4yMkWeaRqtgYxjakiACbQ/BsgpCxYMNPP6+tCXGNxOadMsyOuJmj8WbriZ2mpYxYKoXN8pj3+NCElb/P1X7kZ1hlDwJ9Gv8ZyMdySqB6LmV4qmqSiGT4pfJxqyUTkmcYvPw4FyPmPRriAspq+L7+MUT89zevkRRyZq13mwNYpYxOKeb6w50dTMyGFSEFskYoX9B/kH8rvwGLhoirtbAGDX0JpEqCjjQyvESOCKx3dLtyEDjxl8AEmUFiYpGWVCh9KOrC1YDaoD6uXh16OcQKZyurfQAw4UC8otQjEsDO2Dr3/2BHS7OcukkbgoHqspMmLs1IVuPmsstNQb3RUEBQy6QMAN7lBuvcmVF3q08qdx7CKbjje2RmjUNey2R/2rVqcFNyntSdKiPAm2ANM0hyBSiO4EUaNpcTap/qSyI9rsvRkpqXuUQKVpovWqrMStX2K0enb0upDS8B1Lzk/uDa1gxLmjU3zMUusDJTi0TDI28+aILyGh4REuLA5Q/x7DPV+eQw8mcvdNQ65RRVIvwJZlzaLR+2HghJFbaP1GElkMyKrmCHoaZHTcLlpWOlaqfq+KBU6myeqvsn+KTNxEFdfmXBF1N1yR8RzDLvhSr67FFhRsLl1/q+3IfI7tga60Q4sAsUVCqaPjoempfiVVHCrxGXGoyqntX2Xv3iPaNAoNLMwC+3+v4M046MSW9IewO3aXiQ8gnIierXUBGS9CJ77dYnzNO188DgpvZ4prxZvkexMw+Vb6yDKzE7ti371BM0g32FfmOlvEdgfIeKLkHf45QQDRK/bNgEl9Lb+cbTmdVCbdvIYffX7dMRqUq1yPmnVIMQDDYNKHFzEgo9TeIuy0vzmotUHzqkEwdyJevn9N/vwfwdnLPosusUYECFYA4HvgrlnEiINN8sKUQTlbAgBNicn6u4sH5ESVPkmYZR0/bBILrmKul0lj1SK++no646CI1aYeiMQz9vUsulRdpwhmRsg7A=";

		String request = "<Request><requestString>" + encrypt + "</requestString></Request>";
		System.out.println(request);
	}

	public static String encrypt(String strToEncrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
