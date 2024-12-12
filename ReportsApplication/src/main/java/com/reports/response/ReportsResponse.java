package com.reports.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReportsResponse {

	private Integer userId;
	private String  name;
	private String subName;
	private LocalDate createdDate;
	private LocalDate validateDate;
	private String status;
}
