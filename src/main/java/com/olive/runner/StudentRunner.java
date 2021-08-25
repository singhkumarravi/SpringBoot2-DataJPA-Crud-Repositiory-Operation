package com.olive.runner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Student;
import com.olive.repo.StudentRepositiory;
//@Component
public class StudentRunner implements CommandLineRunner {
    @Autowired
	private StudentRepositiory repo;
    
	@Override
	public void run(String... args) throws Exception {
	System.out.println("Application Started...................");
	System.out.println("Save Object One by One..................");
		repo.save(new Student(10, "Ravi", 2010, "api"));
		repo.save(new Student(20, "Ram", 2010, "api"));
		repo.save(new Student(30, "Shyam", 2010, "bbb"));
		
	System.out.println("Save Multiple Object At a time ...........");
	   repo.saveAll(Arrays.asList(new Student(40, "AAA", 1010, "HYD1"),
			                      new Student(50, "BBB", 1010, "HYD1"),
			                      new Student(60, "CCC", 1010, "HYD1"),
			                      new Student(70, "DDD", 1010, "HYD1")));
	   
	   
	System.out.println("################################################");
	System.out.println("Fetching All Record At a time ...................");
	            Iterable<Student> list = repo.findAll();	
	            list.forEach(System.out::println);
	 //checking Id exits or not           
    System.out.println("################################################");
	System.out.println("Passing Id and checking exits or not............");
	             boolean t1 = repo.existsById(10);
	            boolean t2= repo.existsById(101);
      System.out.println("Data extis :: " + t1 +"............" + t2); 
      
    System.out.println("################################################");
  	System.out.println("Based on Id Fetching One Record ................ ");
  	    Optional<Student> op=repo.findById(101);
	     if(op.isPresent()) {
	    	 Student student = op.get();
	    	 System.out.println("Data is:: " + student);
	     }
	     else {
	    	 System.out.println("No Data Found");
	     }
	     
	    System.out.println("################################################");
	   	System.out.println("Passing List of  Id Fetching List of Record ................ ");  
	   	              Iterable<Student> list1 = repo.findAllById(Arrays.asList(10,20,101));
	                             Iterator<Student> itr =list1.iterator();
	                             while(itr.hasNext()) {
	                              Student s =itr.next();
	                              System.out.println("Data::" + s);
	                             }
	   System.out.println("##################################################");
	   System.out.println("Count Total ROW ...................................");
	         long count = repo.count();
	         System.out.println("count ROW :: " + count);
	}

}
