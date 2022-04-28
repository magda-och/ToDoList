package pl.techleaders.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.techleaders.todolist.model.Task;

//@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
}
