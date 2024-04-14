package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;


import dao.StudentService;

import dao.impl.StudentImpl;

public class Server {
	private static final String URL = "rmi://LAPTOP-KINSRCEK:7878/";

	public static void main(String[] args) {
		try {
			
			
			StudentService studentService = new StudentImpl();
			
			Context context = new InitialContext();
			
			LocateRegistry.createRegistry(7878);
			
			
			context.bind(URL + "studentService", studentService);
			
			System.out.println("Server is running...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
