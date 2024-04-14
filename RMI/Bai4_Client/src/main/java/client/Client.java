package client;

import java.rmi.Naming;

import dao.StudentService;

public class Client {
	private static final String URL = "rmi://LAPTOP-KINSRCEK:7878/";

	public static void main(String[] args) {
		try {
			StudentService studentService = (StudentService) Naming.lookup(URL + "studentService");
			
			studentService.findAll().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
