package com.blake.common;

import java.util.UUID;

import org.apache.shiro.codec.Base64;

public class Base64Util {
	/**
	 * 加密
	 * @param word
	 * @return
	 */
	public static String setString(String word){
		String base64Encoded = Base64.encodeToString(word.getBytes());//加密
		return base64Encoded;
	}
	
	/**
	 * 解密
	 * @param pass
	 * @return
	 */
	public static String getString(String pass){
		String str2 = Base64.decodeToString(pass);//还原
		return str2;
	}
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		String password = "123456".concat(uuid);
		System.out.println(password);
		password = setString(password);
		System.out.println(password);
	}
}
