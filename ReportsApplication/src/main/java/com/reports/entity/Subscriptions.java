package com.reports.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="subscriptions")
@Data
public class Subscriptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subId;
	private String subName;
	private LocalDate createdDate;
	private LocalDate validateDate;
	private String status;
}
