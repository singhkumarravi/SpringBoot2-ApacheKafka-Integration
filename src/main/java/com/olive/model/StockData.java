package com.olive.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "Stock_Data_Tab")
public class StockData {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		private String stockCode;
		private Double stockValue;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date currntDte = new Date();
	
}
