package com.olive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.olive.model.Student;

public interface StudentRepositiory extends CrudRepository<Student, Integer>{

}
