package com.bizzlers.util;

public class Binary {

	
	 public static String[] stringToBin(String s) {
	        System.out.println("Converting: " + s);
	        byte[] b = s.getBytes();
	        String[] sa = new String[s.getBytes().length];
	        for (int i = 0; i < b.length; i++) {
	            sa[i] = Integer.toBinaryString(b[i] & 0xFF);
	        }
	        return sa;
	    }

	    public static String binToString(String[] strar) {
	        byte[] bar = new byte[strar.length];
	        for (int i = 0; i < strar.length; i++) {
	            bar[i] = Byte.parseByte(strar[i], 2);
	            System.out.println(Byte.parseByte(strar[i], 2));

	        }
	        String s = new String(bar);
	        return s;
	    }
}
