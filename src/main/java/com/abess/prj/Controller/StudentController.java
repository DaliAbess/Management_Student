package com.abess.prj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abess.prj.Entity.Student;
import com.abess.prj.Service.StudentService;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
 private StudentService studentService ;

public StudentController(StudentService studentService) {
	super();
	this.studentService = studentService;
} 
@GetMapping("/students" )
public String listStudents(Model model ,HttpSession session ) {
		if( session.getAttribute("connected")=="yes" ) {
	     model.addAttribute("students", studentService.getAllStudents());
          return "students" ;
  }
	
	return "redirect:/login" ;
}
@GetMapping("/students/new" )
public String NewStudentForm(Model model, HttpSession session ) {
	if( session.getAttribute("connected")=="yes" ) {
	Student student = new Student();
	model.addAttribute("student", student);
	return "create_student" ;
	  }
	
		return "redirect:/login" ;
}
@PostMapping("/students")
public String SaveStudent(@ModelAttribute("student") Student student  ) {
    studentService.saveStudent(student);
	return "redirect:/students" ;
}
@GetMapping("/students/edit/{id}")
public String editStudent(@PathVariable Long id ,Model model , HttpSession session ) {
	if( session.getAttribute("connected")=="yes" ) {
	model.addAttribute("student",studentService.getStudentById(id));
	return"edit_student";
	}
	return "redirect:/login" ;
}
@PostMapping("/students/{id}")
public String updateStudent(@PathVariable Long id ,@ModelAttribute("student") Student student 
		,Model model ) {
	//get student from database 
	Student existStudent = studentService.getStudentById(id);
	existStudent.setId(id);
	existStudent.setFirstName(student.getFirstName());
	existStudent.setLastName(student.getLastName());
	existStudent.setEmail(student.getEmail());
	// save updated values 
	studentService.saveStudent(existStudent);
	return"redirect:/students";
}
@GetMapping("/students/{id}")
public String deleteStudent(@PathVariable Long id , HttpSession session  ) {
	if( session.getAttribute("connected")=="yes" ) {
	studentService.deleteStudentById(id);

	return"redirect:/students";
	}
	return "redirect:/login" ;
}
} 
