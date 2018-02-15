package com.emi.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadJson {

	public JsonObject readJsonData() throws FileNotFoundException {
		File jsonInputFile = new File("data.json");
        InputStream iStream = null;
        JsonReader reader = null;
        JsonObject jsonObject = null;
        try {
        	iStream = new FileInputStream(jsonInputFile);
	        reader = Json.createReader(iStream);
	        jsonObject = reader.readObject();
        }finally {
        	 reader.close();
        }
		return jsonObject;
	}
	
	public JsonArray readKeyArray(String key) throws FileNotFoundException {
		return readJsonData().getJsonArray(key);
	}
}
