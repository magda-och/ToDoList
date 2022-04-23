package pl.techleaders.todolist.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.techleaders.todolist.controller.Status;
import pl.techleaders.todolist.model.Task;
import pl.techleaders.todolist.repository.TasksRepository;

import java.util.Optional;

@Service
public class TasksManager {
    private TasksRepository tasksRepository;

    @Autowired
    public TasksManager(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Optional<Task> findById(Long id) {
        return tasksRepository.findById(id);
    }

    public Iterable<Task> findAll() {
        return tasksRepository.findAll();
    }

    public Task save(Task task) {
        return tasksRepository.save(task);
    }

    public void delete(Long id) {
        tasksRepository.deleteById(id);
    }

    public Task update(Long id, Task updatedTask) {
        Task task = tasksRepository.getById(id);
        task.setDescription(updatedTask.getDescription());
        task.setFinalDate(updatedTask.getFinalDate());
        task.setStatus(updatedTask.getStatus());
        return tasksRepository.save(task);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        save(new Task(1L, "Cleaning room", 2022, 4, 20, Status.NOT_STARTED));
        save(new Task(2L, "Washing dishes", 2022, 4, 12, Status.IN_REALIZATION));
        save(new Task(3L, "Washing floors", 2022, 4, 30, Status.NOT_STARTED));
    }
}
