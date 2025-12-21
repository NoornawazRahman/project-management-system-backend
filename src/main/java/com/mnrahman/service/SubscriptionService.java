package com.mnrahman.service;

import com.mnrahman.entity.PlanType;
import com.mnrahman.entity.Subscription;
import com.mnrahman.entity.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription getUsersSubscription(Long userId)throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
