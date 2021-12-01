package org.cleancode.course.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectList {
    private static Long lastId = 1L;
    private List<Project> projects = new ArrayList<>();

    public static Long getLastId() {
        return lastId;
    }

    public static void setLastId(Long lastId) {
        ProjectList.lastId = lastId;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project findProjectByName(String name) {
        return projects
                .stream()
                .filter(project -> name.equals(project.getName()))
                .findFirst()
                .get();
    }
}
