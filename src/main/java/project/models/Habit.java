package project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Habits")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id")
    private Long habitId;

    @NotNull
    @NotBlank
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @NotBlank
    @Column(name = "habit_name")
    private String name;

    private String description;

    @Column(name = "category_id")
    private Long categoryId;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Days> repetitionDays;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long currentStreak;

    private Long maxStreak;

    private Long targetStreak;

    private Boolean isActive;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private HabitPriority priority = HabitPriority.MEDIUM;

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
        if (startDate == null) {
            startDate = LocalDate.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
