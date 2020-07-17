package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class HashPassword {
	public static String hashPassword(String input){
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] messageDigest=md.digest(input.getBytes());
		BigInteger number=new BigInteger(1,messageDigest);
		String hashtext=number.toString(16);
		while(hashtext.length()<32){
		hashtext="0"+hashtext;	
		
	
		}
		return hashtext;
}
	
}
