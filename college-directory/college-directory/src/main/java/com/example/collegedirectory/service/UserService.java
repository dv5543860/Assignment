package com.example.collegedirectory.service;

import com.example.collegedirectory.model.User;
import com.example.collegedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieve all users from the database.
     *
     * @return a list of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieve a user by its ID.
     *
     * @param id the ID of the user
     * @return an Optional containing the user if found, otherwise empty
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Create a new user in the database.
     *
     * @param user the user to be created
     * @return the created user
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Update an existing user.
     *
     * @param id the ID of the user to be updated
     * @param user the user data to update
     * @return an Optional containing the updated user if successful, otherwise empty
     */
    public Optional<User> updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id); // Ensure the ID is set for the update
            return Optional.of(userRepository.save(user));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Delete a user by its ID.
     *
     * @param id the ID of the user to be deleted
     * @return true if the user was deleted, otherwise false
     */
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
