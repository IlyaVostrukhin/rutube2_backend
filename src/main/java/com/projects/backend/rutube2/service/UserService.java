package com.projects.backend.rutube2.service;

import com.projects.backend.rutube2.dto.UserDto;
import com.projects.backend.rutube2.entity.User;
import com.projects.backend.rutube2.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id=" + id + " not found!"));
    }

    public User updateProfile(Long id, UserDto userDto) {
        User user = getById(id);
        User sameUser = userRepository.findByEmail(userDto.getEmail());

        if (sameUser != null && !id.equals(sameUser.getId())) {
            throw new IllegalArgumentException("Email is busy by another user!");
        }

        if (!userDto.getPassword().isEmpty()) {
            //TODO: исправить после подключения авторизации
            user.setPassword(userDto.getPassword());
        }

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setDescription(userDto.getDescription());
        user.setAvatarPath(userDto.getAvatarPath());
        user.setUpdatedDate(new Date());

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
