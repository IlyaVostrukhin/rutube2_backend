package com.projects.backend.rutube2.service;

import com.projects.backend.rutube2.entity.Subscription;
import com.projects.backend.rutube2.entity.User;
import com.projects.backend.rutube2.repo.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public boolean subscribe(Long fromUserId, Long toChannelId) {
        Subscription subscription = subscriptionRepository.findByFromUserIdAndToChannelId(fromUserId, toChannelId);

        if (subscription == null) {
            addSubscription(fromUserId, toChannelId);
            return true;
        }

        deleteSubscription(subscription);
        return false;
    }

    private void addSubscription(Long fromUserId, Long toChannelId) {
        User fromUser = new User();
        fromUser.setId(fromUserId);

        User toChannel = new User();
        toChannel.setId(toChannelId);

        Subscription subscription = new Subscription();
        subscription.setFromUser(fromUser);
        subscription.setToChannel(toChannel);

        subscriptionRepository.save(subscription);
    }

    private void deleteSubscription(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

}
