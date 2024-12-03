package main.java.com.conceptile.quiz.repository;

import main.java.com.conceptile.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findRandom();
}
