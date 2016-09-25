package com.sunglab.bigbanghd;
//by:彼岸花 qq:1279525738
import java.security.MessageDigest;
public class uits {
	public final static String hex(String s) {
		char hexDigits[] = { 'z', 'c', 'o', 'i', '?',
			'$', '-', '7', '8', '9',
			'a', 'b', 'c', 'd', 'l', 'f' };
		try {
			byte[] btInput = s.getBytes();
			//获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			//使用指定的字节更新摘要
			mdInst.update(btInput);
			//获得密文
			byte[] md = mdInst.digest();
			//把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	}
