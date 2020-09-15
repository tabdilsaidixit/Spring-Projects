package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sf.getCurrentSession();

		try {

			Student s3 = new Student("Abc", "Fu", "abc@gmail.com");
			Student s1 = new Student("Def", "Tu", "def@gmail.com");
			Student s2 = new Student("Ghi", "Yu", "ghi@gmail.com");
			
			session.beginTransaction();
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			sf.close();
		}

	}

}
