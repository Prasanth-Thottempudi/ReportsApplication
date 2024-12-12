package com.reports.service;

import com.reports.entity.Users;
import com.reports.exceptions.UserAlreadyExistsException;
import com.reports.request.UserSubscriptionRequest;
import com.reports.response.ReportsResponse;

public interface UserService {
	
	Users saveUserAndSubscriptions(UserSubscriptionRequest request) throws UserAlreadyExistsException;


}
