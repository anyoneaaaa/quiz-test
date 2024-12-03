package main.java.com.conceptile.quiz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    private Long id;
    private String text;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
}
