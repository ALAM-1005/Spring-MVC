package com.jsp.spring_mvc.studentdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.repository.StudentReposistory;

@Service
public class StudentService {

	@Autowired
	private StudentReposistory studentReposistory;
	
	public ModelAndView addStudent(Student student) {
		// saving the student object into the database
		studentReposistory.addStudent(student);
		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("index.jsp");
//		
		return new ModelAndView("index.jsp") ;
	}
	
	
	public ModelAndView displayAllStudents() {
		//Fetching all the students details from the db table
		
		List<Student> students = studentReposistory.findAllStudends();
		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("DisplayAllStudents.jsp");
//		
//		mav.addObject("studentList", students);
		
		return new ModelAndView("DisplayAllStudents.jsp").addObject("studentList",students);
	}


	public ModelAndView findStudentById(int studentId) {
		
		
		Student student = studentReposistory.findStudentById(studentId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("UpdateStudent.jsp");
		mav.addObject("studentObject",student);
		return mav;
	}


	public ModelAndView updateStudent(Student student) {
		studentReposistory.updateStudent(student);
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:displayAllStudents");
		
		
		return new ModelAndView("redirect:displayAllStudents");
	}
	
	
	public ModelAndView deleteStudent(int studentId) {
		studentReposistory.deleteStudentById(studentId);
		
		return new ModelAndView("redirect:displayAllStudents");
	}	
	
}
