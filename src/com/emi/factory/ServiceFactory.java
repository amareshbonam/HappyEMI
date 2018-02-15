package com.emi.factory;

import com.emi.service.DataIterator;
import com.emi.service.impl.DataIteratorImpl;

public class ServiceFactory {
	public static DataIterator getDataIterator() {
		return DataIteratorImpl.getInstance();
	}
}
