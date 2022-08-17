package com.project.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

@SpringBootTest
class ServiceProjectSearchApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void simpleTest() {
		System.out.println("simple test");
	}

	@Test
	void replaceTest() {
		String target = "<b>카카오</b> 판교<b>아지트</b>";

		String replace = target.replaceAll("\\s+|<b>|</b>", "");
		System.out.println(replace);
	}
}
