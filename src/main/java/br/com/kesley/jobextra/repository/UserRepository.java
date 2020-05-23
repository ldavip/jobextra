package br.com.kesley.jobextra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByNameContainingIgnoreCase(String name);
}