package com.other;

import com.blake.common.PinyinTool;


public class Demo1 {
	public static void main(String[] args){
		String str = "уехЩ";
		PinyinTool tool = new PinyinTool();
		System.out.println(tool.toPringYin_LOWERCASE(str));
		System.err.println(tool.toPinYin(str));
	}
}
