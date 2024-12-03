package main.java.com.conceptile.quiz.service;

import main.java.com.conceptile.quiz.model.Question;
import main.java.com.conceptile.quiz.model.UserPerformance;
import main.java.com.conceptile.quiz.repository.QuestionRepository;
import main.java.com.conceptile.quiz.repository.UserPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {
    @ Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserPerformanceRepository userPerformanceRepository;

    public UserPerformance getUser Performance(Long userId) {
        return userPerformanceRepository.findById(userId).orElse(new UserPerformance());
    }

    public Question getRandomQuestion() {
        return questionRepository.findRandom().orElse(null);
    }

    public boolean submitAnswer(Long userId, Long questionId, String selectedAnswer) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            UserPerformance performance = getUser Performance(userId);
            performance.setTotalQuestionsAttempted(performance.getTotalQuestionsAttempted() + 1);
            if (question.get().getCorrectAnswer().equals(selectedAnswer)) {
                performance.setCorrectAnswers(performance.getCorrectAnswers() + 1);
                userPerformanceRepository.save(performance);
                return true;
            }
            userPerformanceRepository.save(performance);
        }
        return false;
    }

    public UserPerformance endQuiz(Long userId) {
        return getUser Performance(userId);
    }
}