package com.springLogin.spring_login_resiger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springLogin.spring_login_resiger.user.UserDetailsOwn;
@Repository
public interface repositoryUserOwn extends JpaRepository<UserDetailsOwn,Long> {
        UserDetailsOwn findByUsername(String username);
}
