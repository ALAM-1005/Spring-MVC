package com.jsp.spring_mvc.studentdb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jsp.spring_mvc.studentdb.entity.Student;

@Repository
public class StudentReposistory {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

	public void addStudent(Student student) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tf = em.getTransaction();
		tf.begin();

		em.persist(student);

		tf.commit();
		em.close();

	}

	public List<Student> findAllStudends() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tf = em.getTransaction();
		tf.begin();

		Query query = em.createQuery("FROM Student");

		List<Student> students = query.getResultList();

		tf.commit();
		em.close();

		return students;

	}
	
	public Student findStudentById(int studentId) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction tran = em.getTransaction();

		tran.begin();

		Student pro = em.find(Student.class, studentId);
		tran.commit();
		em.close();

		return pro;
	}

	public void updateStudent(Student student) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction tran = em.getTransaction();

		tran.begin();

		em.merge(student);

		tran.commit();
		em.close();
	}

	public void deleteStudentById(int studentId) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction tran = em.getTransaction();

		tran.begin();

		Student student = em.find(Student.class, studentId);
		em.remove(student);

		tran.commit();
		em.close();
		

	}
}
