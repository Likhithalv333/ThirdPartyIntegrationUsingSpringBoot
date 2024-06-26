package com.task.biotech.service;

import java.util.List;
import java.util.Map;

public interface ThirdPartyService {
	
	List<Map<String,Object>> getPosts();
	//get data userId

	Map<String, Object> getPostById(int id);
	
	Map<String, Object> updatePosts(Map<String, Object> payload, int id);

	Map<String, Object> deletePost(int id);

	Map<String, Object> inserPosts(Map<String, Object> payLoad);
	
	




}
