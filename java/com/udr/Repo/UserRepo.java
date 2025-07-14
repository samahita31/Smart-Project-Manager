package com.udr.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.udr.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	
	List<User> findByEmailAndPassword(String email, String password);

}
