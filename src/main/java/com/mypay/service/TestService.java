package com.mypay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

	private RestTemplate restTemp;
	String getUrl = "https://dog.ceo/api/breeds/image/random";
	
	@Autowired
	public TestService(RestTemplateBuilder builder) {
		this.restTemp = builder.build();
	}
	
	public void getEmp() {
//		HttpEntity<EntityClass> entity = new HttpEntity<>(emp);
		HttpEntity entity = new HttpEntity("");
		Object res = restTemp.exchange(getUrl, HttpMethod.GET, entity, Object.class);
		System.out.println(res+"");
	}
}
