package com.abess.prj.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.abess.prj.Entity.user;

@EnableJpaRepositories

public interface userRepository extends JpaRepository<user,Long>{
user findByLoginAndPassword(String login, String password);
}
