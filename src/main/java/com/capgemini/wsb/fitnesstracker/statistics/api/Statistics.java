package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "statistics")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_trainings", nullable = false)
    private int totalTrainings;

    @Column(name = "total_distance")
    private double totalDistance;

    @Column(name = "total_calories_burned")
    private int totalCaloriesBurned;

    /**
     * Constructor for Statistics entity
     * @param user user entity
     * @param totalTrainings total number of trainings
     * @param totalDistance total distance
     * @param totalCaloriesBurned total calories burned
     */
    public Statistics(User user,
                      int totalTrainings,
                      double totalDistance,
                      int totalCaloriesBurned) {
        this.user = user;
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    /**
     * Constructor for Statistics entity
     * @param id id of the entity
     * @param user user entity
     * @param totalTrainings total number of trainings
     * @param totalDistance total distance
     * @param caloriesBurned total calories burned
     */
    public Statistics(Long id,
                      User user,
                      int totalTrainings,
                      double totalDistance,
                      int caloriesBurned) {
        this.id = id;
        this.user = user;
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = caloriesBurned;
    }
}