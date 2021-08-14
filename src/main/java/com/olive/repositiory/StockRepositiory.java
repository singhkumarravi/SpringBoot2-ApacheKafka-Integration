package com.olive.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olive.model.StockData;

public interface StockRepositiory extends JpaRepository<StockData, Integer>{

}
