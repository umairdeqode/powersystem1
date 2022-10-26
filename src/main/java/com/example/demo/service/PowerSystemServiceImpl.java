package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.PowerSystemDAO.PowerSystemDAO;
import com.example.demo.PowerSystemEntity.PowerSystemEntity;
import com.example.demo.constants.PowerSystemConstants;
import com.example.demo.exception.NoRecordsFoundException;

@Service
public class PowerSystemServiceImpl implements PowerSystemService{
	
	@Autowired
	private final PowerSystemDAO powerSystemDAO;
	
	public PowerSystemServiceImpl(PowerSystemDAO powerSystemDAO) {
		this.powerSystemDAO=powerSystemDAO;
	}

	@Override
	public void storeData(List<PowerSystemEntity> powerSystemEntity) {
		 powerSystemDAO.saveAll(powerSystemEntity);
		
	}

	@Override
	public JSONArray sendResult(int lowerLimit, int upperlimit) throws NoRecordsFoundException{
		List <PowerSystemEntity> A= powerSystemDAO.findByPostcodeBetween(lowerLimit,upperlimit);
		if(A.isEmpty()) {
		    throw new NoRecordsFoundException(PowerSystemConstants.NoRecords);
		}
		List <PowerSystemEntity> sortedList= A.stream().sorted((p1,p2)->p1.getBatteryName().compareTo(p2.getBatteryName())).collect(Collectors.toList());
		List<String> names = sortedList.stream().map(PowerSystemEntity -> PowerSystemEntity.getBatteryName()).collect(Collectors.toList());
		List<Integer> capacities = sortedList.stream().map(PowerSystemEntity -> PowerSystemEntity.getBatteryCapacity()).collect(Collectors.toList());
        int sum= capacities.stream().collect(Collectors.summingInt(Integer::intValue));
        int avg= sum/sortedList.size();
        JSONArray response = new JSONArray();
		JSONObject data = new JSONObject();
		data.put("SumOfBatteryCapacities", sum);
		data.put("AverageCapacity", avg);
		response.put(names);
		response.put(data);
		return response;
		
	}

}
