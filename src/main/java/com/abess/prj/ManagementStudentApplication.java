package com.abess.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abess.prj.Entity.Student;
import com.abess.prj.Repository.StudentRepository;

@SpringBootApplication
public class ManagementStudentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ManagementStudentApplication.class, args);
	}
    @Autowired
    private StudentRepository studentRepository ;
    @Override 
    public void run(String... args) throws Exception{

    }
    	
    	
    }

