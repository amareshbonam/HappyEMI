package com.emi.util;

import java.util.List;

import com.emi.exception.AllowOnlyIntegerException;

public class DataUtil {
	public static boolean isValidObject(StringBuilder builder){
		if(null != builder && !builder.toString().trim().equals(""))
			return true;
		return false;
	}
	
	public static boolean isValidList(@SuppressWarnings("rawtypes") List list){
		if(null != list && !list.isEmpty())
			return true;
		return false;
	}
	
	public static void sortElements(int[] array) {
	    for(int i=0; i<array.length; i++) {
	    	for(int j=i; j<array.length; j++) {
		    	if(array[i]>array[j]) {
		    		int temp = array[j];
		    		array[j] = array[i];
		    		array[i] = temp;
		    	}
	    	}
	    }
	}
	
	public static void validateNumerics(String[] array) throws AllowOnlyIntegerException{
		String regex = "[0-9]+";
		for(int i=0; i<array.length; i++) {
			if(!array[i].matches(regex))
				throw new AllowOnlyIntegerException();
		}
	}
	

	public static void parseArray(int[] toArray, String[] fromArray) {
		for(int i=0; i< fromArray.length; i++) {
			toArray[i] = Integer.parseInt(fromArray[i]);
		}
	}
	
	public static boolean containsElement(int[] array, int element) {
		for(int i=0; i< array.length; i++) {
			if(array[i] == element)
				return true;
		}
		return false;
	}
	
	public static boolean isValidArray(String[] array) {
		if(null != array && array.length > 0)
			return true;
		return false;
	}
}
