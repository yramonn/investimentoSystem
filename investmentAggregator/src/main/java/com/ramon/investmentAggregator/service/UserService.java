package com.ramon.investmentAggregator.service;

import com.ramon.investmentAggregator.dtos.CreateUserDto;
import com.ramon.investmentAggregator.dtos.UpdateUserDto;
import com.ramon.investmentAggregator.entity.User;
import com.ramon.investmentAggregator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDto createUserDto) {

        var entityConvert = new User(UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.username(),
                createUserDto.password(),
                Instant.now(),
                null);
        var userSaved = userRepository.save(entityConvert);
            return userSaved;
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDto updateUserDto) {
        var id = UUID.fromString(userId);

        var userEntity = userRepository.findById(id);

        if(userEntity.isPresent()) {
            var user = userEntity.get();

            if(updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }

            if(updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }

            userRepository.save(user);
        }
    }

    public void deleteById(String userId) {
        var id = UUID.fromString(userId);

        var userExits = userRepository.existsById(id);

        if(userExits) {
            userRepository.deleteById(id);
        }
    }
}
