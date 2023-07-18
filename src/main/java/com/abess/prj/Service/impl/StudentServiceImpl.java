package com.abess.prj.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abess.prj.Entity.Student;
import com.abess.prj.Repository.StudentRepository;
import com.abess.prj.Service.StudentService;
@Service 

public class StudentServiceImpl implements StudentService {
private StudentRepository studentRepository ;

	public StudentServiceImpl(StudentRepository studentRepository) {
	super();
	this.studentRepository = studentRepository;
}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override 
	public Student saveStudent(Student student ) {
		return studentRepository.save(student) ; 
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student) ;
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get() ;
		
	}

	@Override
	public void deleteStudentById(Long id) {
	 studentRepository.deleteById(id);
		
	}


	

}
