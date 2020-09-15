package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		try {
			
//			Student s = new Student("Dixit", "Tabdil", "sai@gmail.com");
//			session.beginTransaction();
//			System.out.println(s);
//			session.save(s);
//			session.getTransaction().commit();
//			
//			System.out.println("Saved student id:"+ s.getId());
//			session = sf.getCurrentSession();
			session.beginTransaction();
			//System.out.println("Getting student with id:"+ s.getId());
			List<Student> ss = session.createQuery("from Student s WHERE s.lastName='Tu'").getResultList();
			for(Student stu: ss) {
				System.out.println(stu);
			}
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally{
			sf.close();
		}

	}

}
