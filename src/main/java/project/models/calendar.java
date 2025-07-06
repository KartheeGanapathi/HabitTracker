package project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "calendar")
public class calendar {

    @Id
    private CalendarId calendarId;

    @Column(name = "is_completed")
    @Builder.Default
    private Boolean isCompleted = Boolean.FALSE;

    @Column(name = "completed_on")
    private LocalDateTime completedOn;

    private String notes;

    public String getUserId() {
        return calendarId.getUserId();
    }

    public String getHabitId() {
        return calendarId.getHabitId();
    }

    public LocalDate getDate() {
        return calendarId.getDate();
    }
}
