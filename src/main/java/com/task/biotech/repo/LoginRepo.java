package com.task.biotech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.biotech.entity.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login, String> {
	 Login findByUserId(String userId);
}
