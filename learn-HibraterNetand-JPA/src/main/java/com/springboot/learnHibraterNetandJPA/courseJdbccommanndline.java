package com.springboot.learnHibraterNetandJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learnHibraterNetandJPA.jdbc.CoureJdbcRepostiy;
import com.springboot.learnHibraterNetandJPA.jdbc.Course;

@Component
public class courseJdbccommanndline implements CommandLineRunner {
	@Autowired
	private CoureJdbcRepostiy cj;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		cj.update1(new Course(1,"Learn Azure","just28min"));
		cj.update1(new Course(2,"Learn DevOps","just28min"));
		cj.update1(new Course(3,"Learn AWS","just28"));
		cj.delete(1);
		System.out.println(cj.findbyId(2L));
		System.out.println(cj.findbyId(3));
	
	}
	
	

}
