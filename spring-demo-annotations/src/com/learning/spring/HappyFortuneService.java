package com.learning.spring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getService() {
		return "This is happy fortune service";
	}

}
