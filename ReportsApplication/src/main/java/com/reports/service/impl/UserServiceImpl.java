package com.reports.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reports.dao.SubscriptionRepository;
import com.reports.dao.UserRepository;
import com.reports.entity.Subscriptions;
import com.reports.entity.Users;
import com.reports.exceptions.UserAlreadyExistsException;
import com.reports.request.UserSubscriptionRequest;
import com.reports.response.ReportsResponse;
import com.reports.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SubscriptionRepository subscriptionsRepo;

	@Override
	public Users saveUserAndSubscriptions(UserSubscriptionRequest request) throws UserAlreadyExistsException {
		Users userExists=userRepo.findByUsername(request.getUsername());
		if(userExists!=null ) {
			throw  new UserAlreadyExistsException("user already existed!");
		}
		Users user=new Users();
		user.setName(request.getName());
		user.setUsername(request.getUsername());
		
		Subscriptions subscriptions=new Subscriptions();
		subscriptions.setSubName(request.getSubName());
		subscriptions.setCreatedDate(LocalDate.now());
		subscriptions.setValidateDate(LocalDate.now().plusMonths(3));
		subscriptions.setStatus(request.getStatus());
		subscriptionsRepo.save(subscriptions);
		user.setSubscriptions(subscriptions);
		userRepo.save(user);
		
		
		return user;
	}

}
