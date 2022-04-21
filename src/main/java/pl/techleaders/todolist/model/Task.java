package pl.techleaders.todolist.model;

import pl.techleaders.todolist.controller.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ToDoList")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column (name = "Id")
    private Long id;

    @Column (name = "Description")
    private String description;

    @Column (name = "Final_date")
    private LocalDate finalDate;

    @Enumerated(EnumType.STRING)
    @Column (name= "Execution_status")
    private Status status;

    public Task() {
    }

    public Task (Long id, String description, int year, int month, int day, Status status){
        this.id = id;
        this.description = description;
        this.finalDate = LocalDate.of(year, month, day);
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
