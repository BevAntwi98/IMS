package com.qa.connecting.utils;

import java.util.HashMap;

public class HashMapStuff {
	public static void main(String[] args) {
		
		HashMap<String, String> morse= new HashMap<String, String>();
		
		morse.put("-", " a");
		morse.put(".", " n");
		
		for (String i : morse.values()) {
			  System.out.println(i);
			}
		
	}

}
