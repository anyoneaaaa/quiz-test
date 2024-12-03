package main.java.com.conceptile.quiz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPerformance {
    @Id
    private Long userId;
    private int totalQuestionsAttempted;
    private int correctAnswers;

    // Getters and Setters

    public double getScore() {
        return totalQuestionsAttempted == 0 ? 0 : (double) correctAnswers / totalQuestionsAttempted * 100;
    }
}
