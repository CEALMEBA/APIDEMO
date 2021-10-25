package com.example.demo.Repositorys;

import com.example.demo.ModelsDB.CredentialDbModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<CredentialDbModel, Integer> {

    @Query("FROM CredentialDbModel WHERE username = ?1 ")
    CredentialDbModel findCredential(String username);

}
