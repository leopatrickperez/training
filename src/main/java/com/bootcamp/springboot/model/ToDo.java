package com.bootcamp.springboot.model;

public class ToDo {
    private String Project;
    private String Status;

    public ToDo() {
    }
    public  ToDo(String Project, String Status) {
        this.Project = Project;
        this.Status = Status;
    }
    public String getProject() {
        return Project;
    }

    public void setProject(String Project) {
        this.Project = Project;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
