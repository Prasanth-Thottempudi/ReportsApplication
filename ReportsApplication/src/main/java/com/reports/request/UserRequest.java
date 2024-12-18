package com.reports.request;

import lombok.Data;

@Data
public class UserRequest {

    private Integer userId;
    private String name;
    private String username;
    private SubscriptionsRequest subscriptions;

    // SubscriptionsRequest is a nested class to represent the subscription object
    @Data
    public static class SubscriptionsRequest {
        private Integer subscriptionId;
        private String subscriptionName;
        private String subscriptionType;
    }
}
