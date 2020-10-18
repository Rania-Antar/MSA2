package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/jobs")
public class JobRestAPI {
	
private String title = " Hello , I'm the job Microservices";
	
	@Autowired
	private JobService jobService;
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Job> createCandidat(@RequestBody Job job){
		return new ResponseEntity<>(jobService.addJob(job), HttpStatus.OK);		
	}
	
	@PutMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Job> updateJob(@PathVariable(value = "id") int id , @RequestBody Job job){
		return new ResponseEntity<>(jobService.updateJob(id , job), HttpStatus.OK);		
	}
	
	@DeleteMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteJob(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);		
	}

}
