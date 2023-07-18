package com.abess.prj.Service;

import java.util.List;

import com.abess.prj.Entity.Student;

public interface StudentService {
List<Student> getAllStudents();
Student saveStudent(Student student);
Student updateStudent(Student student);
Student getStudentById(Long id );
void deleteStudentById(Long id ); 
}
