package com.example.TaskManager.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.services.TaskService;

@Controller
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping(value="/")
	public String home() {
		return "index";
	}//end of method 'home()'
	
	@GetMapping(value="/list")
	public String list(ModelMap model) {
		Optional<Task> task = taskService.GetTaskById(1);//this was a failed attempt, but had no time to rebound with fix
		model.addAttribute("tasks", task);
		return "list";
	}//end of method 'list()'
	
	@GetMapping(value="/add")
	public String add() {
		return "add";
	}//end of method 'add()'
	
	@PostMapping(value="/add")
	public String addToTask(@RequestParam("fname") String name, @RequestParam("email") String email, 
			@RequestParam("sdate") @DateTimeFormat(pattern="yyyy-mm-dd") Date sDate, @RequestParam("edate") 
	@DateTimeFormat(pattern="yyyy-mm-dd") Date eDate, @RequestParam("desc") String desc, @RequestParam("sev") 
	String sev,@RequestParam("user_id") int u_id ) {
		
		if(!name.isBlank() || !email.isBlank() || !sDate.toString().isBlank() || 
				!eDate.toString().isBlank() || !sev.isBlank() || u_id == 0) {
		Task task = new Task();
		task.setName(name);
		task.setEmail(email);
		task.setStartDate(sDate);
		task.setEndDate(eDate);
		task.setDescription(desc);
		task.setSeverity(sev);
		task.setUser(u_id);
		
		taskService.taskSaver(task);
		}//end of 'if statement'
		
		return "add";
	}//end of method 'addToTask()'
	
	@GetMapping(value="/update")
	public String update() {
		return "update";
	}//end of method 'home()'
	
	@PostMapping(value="/update")
	public String updateTask(@RequestParam("id") int t_ID, @RequestParam("fname") String name, @RequestParam("email") String email, 
			@RequestParam("sdate") @DateTimeFormat(pattern="yyyy-mm-dd") Date sDate, @RequestParam("edate") 
	@DateTimeFormat(pattern="yyyy-mm-dd") Date eDate, @RequestParam("desc") String desc, @RequestParam("sev") 
	String sev,@RequestParam("user_id") int u_id ) {
		taskService.deleteTask(t_ID);
		
		Task task = new Task();
		task.setId(t_ID);
		task.setName(name);
		task.setEmail(email);
		task.setStartDate(sDate);
		task.setEndDate(eDate);
		task.setDescription(desc);
		task.setSeverity(sev);
		task.setUser(u_id);
		
		taskService.taskUpdater(task);
		
		return "update";
	}//end of method 'updateTask()'
	
	@GetMapping(value="/delete")
	public String delete() {
		return "delete";
	}//end of method 'home()'
	
	@PostMapping(value="/delete")
	public String delete(@RequestParam("id") String id) {
		taskService.deleteTask(Integer.parseInt(id));
		return "delete";
	}//end of method 'delete()
	
}
