package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.StudentService;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentImpl extends UnicastRemoteObject implements StudentService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4949690996884699114L;
	private EntityManager em;
	
	public StudentImpl() throws RemoteException{
		em = jakarta.persistence.Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
	}
	
	@Override
	public boolean addStudent(Student student) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(student);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> findAll() {
		
		return em.createQuery("select s from Student s", Student.class).getResultList();
		
	}
	
}
