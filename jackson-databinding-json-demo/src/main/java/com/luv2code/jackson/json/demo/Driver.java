package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectMapper mapper = new ObjectMapper();
			Student stu = mapper.readValue(new File("data/sample-lite.json"), Student.class);
		
			System.out.println(stu.getFirstName());
		}
		catch(Exception exc) {
			
		}

	}

}
