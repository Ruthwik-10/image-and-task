package com.springbootdemo.crudExample.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.springbootdemo.crudExample.entity.Profile;
import com.springbootdemo.crudExample.entity.Task;
import com.springbootdemo.crudExample.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	private TaskService service;
	
    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return service.saveTask(task);
    }
    
    /* Retrieve all the tasks */
	@GetMapping("/tasks")
	public List<Task> findAllTasks(){
		return service.getTasks();
	}
	

	@GetMapping("/taskById/{id}")
	public Task findTaskById(@PathVariable int id) {
		return service.getTaskById(id);
	}
//	@PostMapping("/addTask")
//	public Task addNewTask(@RequestBody  Task task)
//	{
//	   service.addTask(task);
//	   return task;
//	}
	@GetMapping("/taskByProfile/{profileId}")
	public List<Task> findTaskByProfileId(@PathVariable int profileId)
	{
		return service.getTaskByProfileId(profileId);
	}
	
	
	
	@GetMapping("/csvDownload")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "tasks.csv";
	    InputStreamResource file = new InputStreamResource(service.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }	




}