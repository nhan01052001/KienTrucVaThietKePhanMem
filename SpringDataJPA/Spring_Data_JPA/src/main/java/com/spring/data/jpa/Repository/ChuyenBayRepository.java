package com.spring.data.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.data.jpa.entity.ChuyenBay;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, Integer> {
	
	@Query("SELECT  * FROM [CHUYENBAY]")
	ChuyenBay getChuyenBay();
	
}
