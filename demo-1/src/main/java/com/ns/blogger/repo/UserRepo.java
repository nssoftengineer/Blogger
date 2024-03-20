package com.ns.blogger.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ns.blogger.entities.User;

@Repository  
public interface UserRepo extends JpaRepository<User, Integer> {
	
}
