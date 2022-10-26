package com.example.demo.PowerSystemDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.PowerSystemEntity.PowerSystemEntity;

@Repository
public interface PowerSystemDAO extends JpaRepository<PowerSystemEntity, Long> {

	List<PowerSystemEntity> findByPostcodeBetween(int lowerLimit, int upperlimit);
	

}
