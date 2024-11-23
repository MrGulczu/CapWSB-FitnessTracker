package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.capgemini.wsb.fitnesstracker.user.api.UserMapper;

@Component
@RequiredArgsConstructor
public class StatisticsMapper {

    private final UserMapper userMapper;
    private final UserProvider userProvider;

    /**
     * Maps StatisticsDto to Statistics entity
     * @param statistics StatisticsDto
     * @param id id of the entity
     * @return Statistics entity
     */
    Statistics toEntity(StatisticsDtoWithUserId statistics, @Nullable Long id)
    {
        User user = userProvider.getUser(statistics.userId())
                .orElseThrow(() -> new IllegalArgumentException("User with id " + statistics.userId() + " not found"));

        return new Statistics(id,
                user,
                statistics.totalTrainings(),
                statistics.totalDistance(),
                statistics.totalCaloriesBurned());
    }

    /**
     * Maps Statistics entity to StatisticsDto
     * @param statistics Statistics entity
     * @return StatisticsDto
     */
    StatisticsDto toDto(Statistics statistics)
    {
        return new StatisticsDto(
                statistics.getId(),
                userMapper.toDto(statistics.getUser()),
                statistics.getTotalTrainings(),
                statistics.getTotalDistance(),
                statistics.getTotalCaloriesBurned()
        );
    }

    /**
     * Maps UserDto to User entity with state of previous entity
     *
     * @param statisticsDtoWithUserId UserDto
     * @param statistics              User
     * @return User
     */
    public Statistics toUpdateEntity(StatisticsDtoWithUserId statisticsDtoWithUserId, Statistics statistics) {
        if (statisticsDtoWithUserId.totalTrainings() != 0) {
            statistics.setTotalTrainings(statisticsDtoWithUserId.totalTrainings());
        }

        if (statisticsDtoWithUserId.totalDistance() != 0) {
            statistics.setTotalDistance(statisticsDtoWithUserId.totalDistance());
        }

        if (statisticsDtoWithUserId.totalCaloriesBurned() != 0) {
            statistics.setTotalCaloriesBurned(statisticsDtoWithUserId.totalCaloriesBurned());
        }

        if (statisticsDtoWithUserId.userId() != 0) {
            User user = userProvider.getUser(statisticsDtoWithUserId.userId())
                    .orElseThrow(() -> new IllegalArgumentException("User with id " + statisticsDtoWithUserId.userId() + " not found"));
            statistics.setUser(user);
        }

        return statistics;
    }
}
