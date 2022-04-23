package pl.techleaders.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.techleaders.todolist.manager.TasksManager;
import pl.techleaders.todolist.model.Task;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TasksManager tasksManager;

    @Autowired
    public TaskController(TasksManager tasksManager) {
        this.tasksManager = tasksManager;
    }

    @GetMapping
    public Iterable<Task> getAllTasks() {
        return tasksManager.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return tasksManager.findById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        tasksManager.save(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        tasksManager.update(id, updatedTask);
        return updatedTask;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        tasksManager.delete(id);
        return "Usunięto zadanie";
    }
}
