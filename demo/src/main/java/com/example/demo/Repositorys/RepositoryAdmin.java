package com.example.demo.Repositorys;


import com.example.demo.ModelsDB.AdminDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryAdmin extends CrudRepository<AdminDB, Long> {
}
