package com.projects.backend.rutube2.repo;

import com.projects.backend.rutube2.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findByFromUserIdAndToChannelId(Long fromUserId, Long toChannelId);

}
