package com.Mouad.CineBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mouad.CineBase.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
