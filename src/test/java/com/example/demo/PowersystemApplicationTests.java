package com.example.demo;

import java.util.List;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.PowerSystemController;
import com.example.demo.PowerSystemDAO.PowerSystemDAO;
import com.example.demo.PowerSystemEntity.PowerSystemEntity;
import com.example.demo.service.PowerSystemServiceImpl;

@SpringBootTest
class BackendChallengeApplicationTests {
    
    @Resource
    private PowerSystemDAO powerSystemDAO;
    
    
    
    @Resource   
    private PowerSystemServiceImpl powerSystemServiceImpl;
    
    
    @Resource
    private PowerSystemController powerSystemController;
    
    
    @BeforeEach
    void setup()  {
        
        PowerSystemEntity pse=new PowerSystemEntity();      
        pse.setBatteryName("Washington");
        pse.setBatteryCapacity(12600);
        pse.setPostcode("5000");
        
    }
    
    

    @Test
    public void storeDataTest() {
        PowerSystemEntity pse=new PowerSystemEntity(1, "Washington","5000",12600);
        powerSystemDAO.save(pse);
       Assertions.assertThat(!powerSystemDAO.findAll().isEmpty());    
        
    }
    

    @Test
    public void sendResultTest() {
        List<PowerSystemEntity> list=powerSystemDAO.findByPostcodeBetween(3000,16000);
       Assertions.assertThat(list).isNotNull();
    }

    
    
    }
