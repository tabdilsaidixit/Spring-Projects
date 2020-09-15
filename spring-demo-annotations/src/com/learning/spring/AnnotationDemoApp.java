package com.learning.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get bean
		Coach coach = context.getBean("tennisCoach", Coach.class);
		//call method
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortuneService());
		//close context
		
		context.close();
	}

}
