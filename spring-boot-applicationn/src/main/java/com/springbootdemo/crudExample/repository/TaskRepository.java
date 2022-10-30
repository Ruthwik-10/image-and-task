package com.springbootdemo.crudExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootdemo.crudExample.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	@Query("from Task where profile_id=?1")
    List<Task> findTaskByProfileId(int id);
		

}