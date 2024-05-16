package com.test.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity //signals the repo which we have the Jpa, that the class Task should be treated as a table in the database
public class Task {

    @Id //makes it the primary key
    @GeneratedValue //generates the id automatically.
    private long taskId;

    private String description; //@notblank
    private boolean isComplete;

    public Task() {
    }

    public Task(long taskId, String description, boolean isComplete) {
        this.taskId = taskId;
        this.description = description;
        this.isComplete = isComplete;
    }


    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}




