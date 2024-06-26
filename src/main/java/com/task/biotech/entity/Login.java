package com.task.biotech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class Login {

	 @Id
	    @Column(name = "user_id")
	    private String userId;

	    @Column(name = "user_name")
	    private String userName;
	    
	    @Column(name = "pass_word")
	    private String password;

	    @Column(name = "conform_pass")
	    private String conformPass;

    // Getters and setters omitted for brevity
    

    @Override
    public String toString() {
        return "Login{" +
                
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", conformPass='" + conformPass + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConformPass() {
		return conformPass;
	}

	public void setConformPass(String conformPass) {
		this.conformPass = conformPass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
