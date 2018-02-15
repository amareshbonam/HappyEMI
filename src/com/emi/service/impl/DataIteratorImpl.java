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
		
	/*public void iterateOverJSONArray(StringBuilder value, JsonArray jsonArray, int index){
		for(int i=0; i<3; i++) {
			if(jsonArray.size() > index ) {
				value.append(jsonArray.get(index));
				index++;
				iterateOverJSONArray(value, jsonArray, index);
			}
		}
	}
	
	public void iterateOverJSONObject(List<String> values, StringBuilder builder, JsonObject jsonObject, int keyIndex, String[] keys){
		for(;keyIndex < keys.length; keyIndex++) {
			JsonArray jsonArray = jsonObject.getJsonArray(keys[keyIndex]);
			for(int i=0; i<jsonArray.size(); i++) {
//				if(!StringBuilderUtil.isValidObject(builder))
//					builder = new StringBuilder();
				if(keys.length > keyIndex+1) {
					builder.append(jsonArray.get(i));
					iterateOverJSONObject(values, builder, jsonObject, keyIndex+1, keys);
					builder = new StringBuilder();
				} else if(DataUtil.isValidObject(builder)){ 
//					if(builder.length()+1 ==  keys.length)
						values.add(builder.toString().concat(jsonArray.get(i).toString()));
//					if(keyIndex+1 == 3 && i+1 == jsonArray.size())
//						break;
				}
			}
		}
	}
	
	public void iterateOverJSONObject(JsonObject jsonObject, String[] keys) {
		List<String> oldList = new ArrayList<String>();
		for(int i=keys.length-1; i>=0; i--) {
			List<String> newList = new ArrayList<String>();
			JsonArray jsonArray = jsonObject.getJsonArray(keys[i]);
			addArrayToList(jsonArray, oldList, newList);
			oldList = newList;
		}
	}
	
	public List<String> addArrayToList(JsonArray jsonArray,List<String> oldList, List<String> newList) {
		for(int j=0; j<jsonArray.size(); j++) {
			if(DataUtil.isValidList(oldList)) {
				for(int i=0; i<oldList.size(); i++) {
					newList.add(jsonArray.get(j).toString().concat(oldList.get(i)));
				}
			} else {
				newList.add(jsonArray.get(j).toString());
			}
		}
		return newList;
	}*/
	
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
//		for(int i=keys.length-1; i>=0; i--) {
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
			System.out.print(object.toString());
		}
	}
	
}
