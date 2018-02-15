package com.emi.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EMIConstants {
	public static Map<Integer, List<String>> constantsMap = new HashMap<Integer, List<String>>();
	public final static String[] array1 = {"a", "b", "c"};
	public final static String[] array2 = {"d","e","f"};
	public final static String[] array3 = {"g","h","i"};
	public final static String[] array4 = {"j","k","l"};
	public final static String[] array5 = {"m","n","o"};
	public final static String[] array6 = {"p","q","r","s"};
	public final static String[] array7 = {"t","u","v"};
	public final static String[] array8 = {"w","x","y","z"};
	static {
		constantsMap.put(2, Arrays.asList(array1));
		constantsMap.put(3, Arrays.asList(array2));
		constantsMap.put(4, Arrays.asList(array3));
		constantsMap.put(5, Arrays.asList(array4));
		constantsMap.put(6, Arrays.asList(array5));
		constantsMap.put(7, Arrays.asList(array6));
		constantsMap.put(8, Arrays.asList(array7));
		constantsMap.put(9, Arrays.asList(array8));
	}
}
