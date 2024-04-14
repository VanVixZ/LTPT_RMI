package main;

import java.time.LocalDate;

import dao.StudentService;
import dao.impl.StudentImpl;
import entity.Student;

public class main {
	
	public static void main(String[] args) {
		StudentService studentDAO = new StudentImpl();
		
		studentDAO.findAll()
			.forEach(System.out::println);
	
		
		
	}
	
	
}
