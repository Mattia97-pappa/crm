package com.example.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crm.entity.Operatore;

@Repository
public interface OperatoreRepository extends JpaRepository<Operatore, Integer> {
    Operatore findByUsername(String username); 



}
