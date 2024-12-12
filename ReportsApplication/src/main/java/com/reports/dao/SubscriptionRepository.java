package com.reports.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reports.entity.Subscriptions;

public interface SubscriptionRepository  extends JpaRepository<Subscriptions, Long>{

}
