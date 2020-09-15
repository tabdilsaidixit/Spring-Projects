package com.learning.springboot.demo.mycoolapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String getDate() {
		return "Hello";
	}
	@GetMapping("/1")
	public String getDate1() {
		return "Hello";
	}
}
