package com.reports.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserSubscriptionRequest {

	private String  name;
	private String subName;
	private String username;
	private LocalDate createdDate;
	private LocalDate validateDate;
	private String status;
}
