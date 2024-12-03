package main.java.com.conceptile.quiz.repository;
import main.java.com.conceptile.quiz.model.UserPerformance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPerformanceRepository extends JpaRepository<UserPerformance, Long> {
}