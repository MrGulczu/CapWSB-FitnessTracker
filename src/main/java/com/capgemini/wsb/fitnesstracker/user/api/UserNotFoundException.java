package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 * Exception indicating that the {@link User} was not found.
 */
@SuppressWarnings("squid:S110")
public class UserNotFoundException extends NotFoundException {

    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     * @param message the detail message.
     */
    private UserNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new UserNotFoundException with the specified detail message and cause.
     * @param id ID of user which was not found.
     */
    public UserNotFoundException(Long id) {
        this("User with ID=%s was not found".formatted(id));
    }

}
