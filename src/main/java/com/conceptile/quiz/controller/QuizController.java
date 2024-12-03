package main.java.com.conceptile.quiz.controller;

import main.java.com.conceptile.quiz.model.Question;
import main.java.com.conceptile.quiz.model.UserPerformance;
import main.java.com.conceptile.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<UserPerformance> getDashboard(@PathVariable Long userId) {
        UserPerformance performance = quizService.getUser Performance(userId);
        return ResponseEntity.ok(performance);
    }

    @PostMapping("/take/{userId}")
    public ResponseEntity<Question> takeQuiz(@PathVariable Long userId) {
        Question question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<Boolean> submitAnswer(@PathVariable Long userId, @RequestParam Long questionId, @RequestParam String selectedAnswer) {
        boolean isCorrect = quizService.submitAnswer(userId, questionId, selectedAnswer);
        return ResponseEntity.ok(isCorrect);
    }

    @PostMapping("/end/{userId}")
    public ResponseEntity<UserPerformance> endQuiz(@PathVariable Long userId) {
        UserPerformance performance = quizService.endQuiz(userId);
        return ResponseEntity.ok(performance);
    }
}