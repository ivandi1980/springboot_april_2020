package com.example.demo.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobs {
	
	@Scheduled(fixedDelay = 2000, initialDelay = 10000)
	public void fixedDelay() {
		System.out.println("Fixed delay: " + new Date());
	}
	
	@Scheduled(cron = "0 34 17 * * ?")
	public void scheduledCronJob() {
		System.out.println("Cron: " + new Date());
	}
	

}
