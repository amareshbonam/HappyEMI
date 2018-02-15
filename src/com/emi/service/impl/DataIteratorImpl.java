package com.emi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.emi.service.DataIterator;
import com.emi.util.DataUtil;

public class DataIteratorImpl implements DataIterator{

	public static DataIterator getInstance() {
		return new DataIteratorImpl();
	}
	
	@Override
	public List<String> addArrayToList(List<String> list, List<String> oldList, List<String> newList) {
		for(int j=0; j<list.size(); j++) {
			if(DataUtil.isValidList(oldList)) {
				for(int i=0; i<oldList.size(); i++) {
					newList.add(list.get(j).concat(oldList.get(i)));
				}
			} else {
				newList.add(list.get(j));
			}
		}
		return newList;
	}

	@Override
	public void iterateOverDataObject(List<String> oldList, Map<Integer, List<String>> dataMap, int[] keys, int index) {
		List<String> newList = new ArrayList<String>();
		List<String> list = dataMap.get(keys[index]);
		addArrayToList(list, oldList, newList);
		if(DataUtil.isValidList(list)) {
			oldList.clear(); oldList.addAll(newList);
		}
		if(index != 0) {
			iterateOverDataObject(oldList, dataMap, keys, --index);
		}
	}

	@Override
	public void displayElements(@SuppressWarnings("rawtypes") List list) {
		for(Object object: list) {
			System.out.print(object.toString().concat(", "));
		}
	}
	
}
