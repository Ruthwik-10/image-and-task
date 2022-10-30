package com.springbootdemo.crudExample.service;

import java.io.ByteArrayInputStream;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//import com.springbootdemo.crudExample.entity.Profile;
//import com.springbootdemo.crudExample.entity.Profile;
import com.springbootdemo.crudExample.entity.Task;
import com.springbootdemo.crudExample.helper.taskHelper;
import com.springbootdemo.crudExample.repository.TaskRepository;

//import com.springbootdemo.crudExample.*;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repository;
	
	//	Saves the task into repository
    public Task saveTask(Task task) {
    	return repository.save(task);
    }
    
    public List<Task> getTasks(){
    	return repository.findAll();
    }
    
    public Task getTaskById(int id){
    	return repository.findById(id).orElse(null);
    }

//    public Task addTask(Task task)
//    {
//    	return repository.save(task);
//    }
    public List<Task> getTaskByProfileId(int pid){
    	List<Task> list= repository.findTaskByProfileId(pid);
    	return list;
    }
    
    
    public ByteArrayInputStream load() {
        List<Task> tasks = repository.findAll();

        ByteArrayInputStream in = taskHelper.tasksToCSV(tasks);
        return in;
      }


    
}
