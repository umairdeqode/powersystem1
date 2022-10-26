package com.example.demo.service;

import java.util.List;

import org.json.JSONArray;

import com.example.demo.PowerSystemEntity.PowerSystemEntity;

public interface PowerSystemService {
	void storeData(List<PowerSystemEntity> powerSystemEntity);


	public JSONArray sendResult(int lowerLimit, int upperlimit);

}
