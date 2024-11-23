package com.capgemini.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * Updates an existing user.
     * @param user User
     * @return User
     */
    User updateUser(User user);

    /**
     * Deletes an existing user.
     * @param userId Long
     */
    void deleteUser(Long userId);
}
