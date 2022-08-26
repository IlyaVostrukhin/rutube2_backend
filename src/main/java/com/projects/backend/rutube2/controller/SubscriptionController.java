package com.projects.backend.rutube2.controller;

import com.projects.backend.rutube2.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    //ToDo: после авторизации -> метод только для авторизованных + из сессии брать id пользователя
    @PostMapping("/{channelId}")
    public ResponseEntity<Boolean> subscribeToChannel(@PathVariable("channelId") Long channelId, @RequestBody Long id) {
        return ResponseEntity.ok(subscriptionService.subscribe(id, channelId));
    }

}
