package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		try {
			Instructor tempInstructor = new Instructor("Sai", "Dixit", "sai@gmail.com");
			InstructorDetail tempInsDetail = new InstructorDetail("test channel", " code");
			tempInstructor.setInstructorDetail(tempInsDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally{
			sf.close();
		}

	}

}
