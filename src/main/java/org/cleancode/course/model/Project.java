package org.cleancode.course.model;

public class Project {
    private String name;
    private Tasks tasks = new Tasks();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }
}
