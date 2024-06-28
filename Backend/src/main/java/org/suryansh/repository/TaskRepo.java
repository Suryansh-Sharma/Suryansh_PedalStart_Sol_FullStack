package org.suryansh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suryansh.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {
}