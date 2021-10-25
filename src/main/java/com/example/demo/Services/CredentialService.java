package com.example.demo.Services;

import com.example.demo.Models.Credential;
import com.example.demo.ModelsDB.CredentialDbModel;
import com.example.demo.Repositorys.CredentialRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepo;



    public Credential getOneRecord(int id){
        CredentialDbModel credentialDbModel = credentialRepo.findById(id).get();
        return new Credential(credentialDbModel);
    }
    public Credential findRecordemail(String username){
        CredentialDbModel credential = credentialRepo.findCredential(username);
        return new Credential(credential);
    }
}
