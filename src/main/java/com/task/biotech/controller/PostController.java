package com.task.biotech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.biotech.entity.Login;
import com.task.biotech.service.LoginService;
import com.task.biotech.service.ThirdPartyService;
@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public String register(@RequestBody Login login) {
        return loginService.registration(login);
    }

    @PostMapping("Login")
    public ResponseEntity<String> login(@RequestBody Login loginRequest) {
    	
    	 String userId = loginRequest.getUserId();
         String password = loginRequest.getPassword();
         
         boolean isAuthenticated = loginService.authenticateUser(userId, password);
         if (isAuthenticated) {
             return ResponseEntity.ok("Login successful!");
         } else {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
         }
    }
	
	@Autowired
    private ThirdPartyService partyService;
	
    @GetMapping("/getPosts")
    List<Map<String,Object>> getAllPosts()
    {
    	return partyService.getPosts();
    	
    }
    
    @GetMapping("/getPostById/{id}")
    Map<String,Object> getPostById(@PathVariable int id){
    	return partyService.getPostById(id);
    }
    
    @PostMapping("/insertPosts")
    Map<String,Object> InsertPost(@RequestBody Map<String,Object>payLoad){
    	return partyService.inserPosts(payLoad);
    }
    
    @PutMapping("/updatePost/{id}")
     Map<String, Object> updatePost(@RequestBody Map<String, Object> payload, @PathVariable int id) {
        return partyService.updatePosts(payload, id);
    }
//
    @DeleteMapping("/deletePost/{id}")
     Map<String, Object> deletePost(@PathVariable int id) {
        return partyService.deletePost(id);
    }
    
    
}
