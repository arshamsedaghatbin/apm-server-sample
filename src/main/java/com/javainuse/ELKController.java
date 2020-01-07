package com.javainuse;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class ELKController {
	private static final Logger LOG = Logger.getLogger(ELKController.class.getName());

	@Autowired
	RestTemplate restTemplete;

	@Autowired
	private ServiceTest serviceTest;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/elk")
	public String helloWorld() {
		serviceTest.test();
		String response = "Welcome to javainuse" + new Date();
//		Test test=new Test();
//		test.setName("arsham");
//		test.setFatherName("farzad");
//		try {
//			LOG.error(new ObjectMapper().writeValueAsString(test));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		;
		return response;
	}

	public static Boolean s=false;
	@RequestMapping(value = "/exception")
	public String exception() throws Exception {
		if (s){
			String response = "";
			s=false;
			Thread.sleep(10000l);

			return response;
		}
		s=true;
		throw new Exception("Opps Exception raised....");
//		try {
//			throw new Exception("Opps Exception raised....");
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e);
//
//			StringWriter sw = new StringWriter();
//			PrintWriter pw = new PrintWriter(sw);
//			e.printStackTrace(pw);
//			String stackTrace = sw.toString();
//			LOG.error("Exception - " + stackTrace);
//			response = stackTrace;
//			throw  e;
//		}
	}
	
}
