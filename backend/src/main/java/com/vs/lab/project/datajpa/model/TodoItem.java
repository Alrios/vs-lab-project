package com.vs.lab.project.datajpa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TodoItem")
public class TodoItem {
    @Id
    @Column(name = "todo", length = 1024, nullable = false)
	private String todo;

    @Column(name = "priority")
    private int priority;


    public TodoItem(){}

    public TodoItem(String todo, int priority){
        this.todo = todo;
        this.priority = priority;
    }

    public String getTodo() {
		return this.todo;
	}
	public void setTodo(String todo){
		this.todo = todo;
	}

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }      
}
