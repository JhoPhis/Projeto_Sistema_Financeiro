package com.sistema.financeiro.sisfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.financeiro.sisfin.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
