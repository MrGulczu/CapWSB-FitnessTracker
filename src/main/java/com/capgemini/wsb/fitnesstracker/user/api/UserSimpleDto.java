package com.capgemini.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/**
 * UserSimpleDto is a simple representation of User entity.
 */
public record UserSimpleDto(@Nullable Long id, String firstName, String lastName){}