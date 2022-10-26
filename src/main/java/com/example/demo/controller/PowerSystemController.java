package com.example.demo.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PowerSystemEntity.PowerSystemEntity;
import com.example.demo.constants.PowerSystemConstants;
import com.example.demo.service.PowerSystemService;

@RestController
@RequestMapping("/powerSystem")
public class PowerSystemController {
	
	@Autowired
	private final PowerSystemService powerSystemService;
	
	public PowerSystemController(PowerSystemService powerSystemService) {
		this.powerSystemService=powerSystemService;
	}
	
	@PostMapping
	public String storeData(@RequestBody List<PowerSystemEntity> powerSystemEntity) {
		powerSystemService.storeData(powerSystemEntity);
		return ("Saved!");
	}
	
	@GetMapping("/{ll}/{ul}")
	public ResponseEntity<?> sendResult(@PathVariable("ll") int lowerLimit, @PathVariable("ul") int upperLimit ){
	    
	    if(lowerLimit==0 || upperLimit ==0 || lowerLimit>upperLimit) {
            return new ResponseEntity<>(PowerSystemConstants.invalidRange,HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
            }
	    
	    JSONArray response = new JSONArray();
	    response.put(powerSystemService.sendResult(lowerLimit, upperLimit));
	    return ResponseEntity.ok(response);
	}
	
}
