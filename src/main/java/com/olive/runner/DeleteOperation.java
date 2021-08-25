package com.olive.runner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Student;
import com.olive.repo.StudentRepositiory;
@Component
public class DeleteOperation implements CommandLineRunner {
    @Autowired
	private StudentRepositiory repo;
    
	@Override
	public void run(String... args) throws Exception {
	System.out.println("Application Started...................");
		
	System.out.println("Save Multiple Object At a time ...........");
	   repo.saveAll(Arrays.asList(new Student(40, "AAA", 1010, "HYD1"),
			                      new Student(50, "BBB", 1010, "HYD1"),
			                      new Student(5, "BBB", 1010, "HYD1"),
			                      new Student(10, "BBB", 1010, "HYD1"),
			                      new Student(60, "CCC", 1010, "HYD1"),
			                      new Student(70, "DDD", 1010, "HYD1")));
	   System.out.println("Delete Record  based ID ........................");
	    repo.deleteById(40);
	    System.out.println("Delete multiple Record At a time ..............");
	    repo.deleteAll(Arrays.asList(new Student(60, "", 421, ""),
	    		                     new Student(70, "", 421, ""),
	    		                     new Student(50, "", 421, "")
	    		 ));
	    
     System.out.println("Delete One Record Based on pk ..............");
        repo.delete(new Student(10, "", 10, ""));
        
     System.out.println("Delete All Record At A time ..............");
        repo.deleteAll();
        
	}

}
