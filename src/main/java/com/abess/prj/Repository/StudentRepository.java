package com.abess.prj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abess.prj.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	

}
