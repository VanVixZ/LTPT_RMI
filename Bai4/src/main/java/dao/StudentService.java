package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Student;

public interface StudentService extends Remote {
	
	public boolean addStudent(Student student) throws RemoteException;
	// Danh sách tất cả sinh viên
	public List<Student> findAll() throws RemoteException;
	
}
