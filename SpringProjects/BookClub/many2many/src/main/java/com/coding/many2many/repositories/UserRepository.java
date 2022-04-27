package com.coding.many2many.repositories;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.many2many.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
 Optional<User> findById(HttpSession session);
 User findByEmail(String email);
 
}
