package com.qlp.cms.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtil {
	
	private static final RandomNumberGenerator rng = new SecureRandomNumberGenerator();
	private static final int hashIterations = 2;
	
	public static String createSalt(){
		return rng.nextBytes().toBase64();
	}
	
	public static String encrypt(String loginName,String password,String salt){
		ByteSource saltObj = ByteSource.Util.bytes(loginName + salt);
		return new Sha256Hash(password, saltObj, hashIterations).toBase64();
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("root","123456","ZSWxKwJyy8eTslaqktQ+Pw=="));
	}

}
