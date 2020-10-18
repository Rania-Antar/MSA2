package com.esprit.microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	public Job addJob(Job job) {
		return jobRepository.save(job);
	}
	public Job updateJob(int id , Job newJob)
	{
		if (jobRepository.findById(id).isPresent()){
			Job existingJob = jobRepository.findById(id).get();
			existingJob.setService(newJob.getService());
			existingJob.setEtat(newJob.isEtat());
			
			return jobRepository.save(existingJob);
		} else 
			return null;
	}
	public String deleteJob(int id) {
		if (jobRepository.findById(id).isPresent()) {
			jobRepository.deleteById(id);
			return "Job supprimé";
		} else 
			return "Job non supprimé" ;
	}
	
	public List<Job> allJobs() {
		List<Job> jobs = jobRepository.findAll();
		return jobs;
	}
	public Job getJobById(int id){
		Job job = jobRepository.findById(id).get();
		return job;
	}

}
