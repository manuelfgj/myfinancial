package com.manuelfgj.myfinancial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuelfgj.myfinancial.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
