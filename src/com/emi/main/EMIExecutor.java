package com.emi.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.emi.exception.AllowOnlyIntegerException;
import com.emi.factory.ServiceFactory;
import com.emi.service.DataIterator;
import com.emi.service.EMIConstants;
import com.emi.util.DataUtil;

public class EMIExecutor {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			if(DataUtil.isValidArray(args)) {
				DataIterator iterator = ServiceFactory.getDataIterator();
				DataUtil.validateNumerics(args);
				int keys[] = new int[args.length];
				DataUtil.parseArray(keys, args);
				if(!DataUtil.containsElement(keys, 1)) {
					DataUtil.sortElements(keys);
					List<String> sortedList =  new ArrayList<String>();
					iterator.iterateOverDataObject(sortedList, EMIConstants.constantsMap, keys, keys.length-1);
					iterator.displayElements(sortedList);
				} else {
					System.out.println("Numeric 1 is not allowed");
				}
			} else {
				System.out.println("Please Provide Input to process");
			}
		} catch(AllowOnlyIntegerException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
