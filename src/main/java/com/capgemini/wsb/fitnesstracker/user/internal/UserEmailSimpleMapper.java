package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.stereotype.Component;

@Component
class UserEmailSimpleMapper {
    /**
     * Maps User entity to UserEmailSimpleDto
     * @param user User
     * @return UserEmailSimpleDto
     */
    UserEmailSimpleDto toEmailSimpleDto(User user) {
        return new UserEmailSimpleDto(user.getId(), user.getEmail());
    }

    /**
     * Maps UserEmailSimpleDto to User entity
     * @param userDto UserEmailSimpleDto
     * @return User
     */
    User toSimpleEmailEntity(UserEmailSimpleDto userDto) {
        return new User(null, null, null, userDto.email());
    }
}
