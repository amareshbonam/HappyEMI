package com.emi.service;

import java.util.List;
import java.util.Map;

public interface DataIterator {
	public List<String> addArrayToList(List<String> list, List<String> oldList, List<String> newList);
	public void iterateOverDataObject(List<String> oldList, Map<Integer, List<String>> dataMap, int[] keys, int index);
	public void displayElements(@SuppressWarnings("rawtypes") List list);
}
