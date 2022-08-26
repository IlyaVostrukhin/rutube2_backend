package com.projects.backend.rutube2.controller;

import com.projects.backend.rutube2.dto.UserDto;
import com.projects.backend.rutube2.entity.User;
import com.projects.backend.rutube2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //ToDo: после авторизации -> метод только для авторизованных + из сессии брать id пользователя
    @PostMapping("/profile")
    public ResponseEntity<User> getProfile(@RequestBody Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    //ToDo: после авторизации -> метод только для авторизованных + из сессии брать id пользователя
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateProfile(id, userDto));
    }

    @PostMapping
    //ToDo: после авторизации -> метод только для авторизованных + из сессии брать id пользователя
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

}
