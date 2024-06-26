package com.task.biotech.service;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;







@Service
public class ThirdpartyServiceImp implements ThirdPartyService {

	
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String POSTS_PATH = "posts";
    private static final String POST_BY_ID_PATH = "posts/";
	
	
	
	@Autowired
	private RestTemplate restTemplate;

	  @Override
	    public List<Map<String, Object>> getPosts() {
		  HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
	        String url = new StringBuilder(BASE_URL).append(POSTS_PATH).toString();
	        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
	            url,
	            HttpMethod.GET,
	            httpEntity,
	            new ParameterizedTypeReference<List<Map<String, Object>>>() {}
	        );
	        return response.getBody();
	 } 
	  
	  @Override
	  public Map<String,Object> getPostById(int id){
		  HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
	        String url = new StringBuilder(BASE_URL).append(POST_BY_ID_PATH).append(id).toString();
	        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
	            url,
	            HttpMethod.GET,
	            httpEntity,
	            new ParameterizedTypeReference<Map<String, Object>>() {}
	        );
		return response.getBody();
		  
	  }
	  
//	  //insertion
//	  
	  @Override
	  public Map<String,Object> inserPosts(Map<String,Object> payLoad){
		  HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(payLoad, gethttpHeaders());
	        String url = new StringBuilder(BASE_URL).append(POSTS_PATH).toString();
	        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
	            url,
	            HttpMethod.POST,
	            httpEntity,
	            new ParameterizedTypeReference<Map<String, Object>>() {}
	        );
		  return response.getBody();
	  }
	  
	  //update the data
	  @Override
	  public Map<String, Object> updatePosts(Map<String, Object> payload, int id) {
		  HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(payload, gethttpHeaders());
	        String url = new StringBuilder(BASE_URL).append(POST_BY_ID_PATH).append(id).toString();
	        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
	            url,
	            HttpMethod.PUT,
	            httpEntity,
	            new ParameterizedTypeReference<Map<String, Object>>() {}
	        );
	        return response.getBody();
	    }
	  @Override
	  public Map<String, Object> deletePost(int id) {
		  HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
	        String url = new StringBuilder(BASE_URL).append(POST_BY_ID_PATH).append(id).toString();
	        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
	            url,
	            HttpMethod.DELETE,
	            httpEntity,
	            new ParameterizedTypeReference<Map<String, Object>>() {}
	        );
	        return response.getBody();
	    }
//	  
	  
	private HttpHeaders gethttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
