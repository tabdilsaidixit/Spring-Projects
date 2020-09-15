package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		try {
			
			Student s = new Student("Sai", "Tabdil", "sai@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally{
			sf.close();
		}

	}

}
