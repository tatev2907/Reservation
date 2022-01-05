package com.example.reservation.Repository;

import com.example.reservation.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {
    boolean existsByPassportinfoAllIgnoreCase(String passportinfo);

}