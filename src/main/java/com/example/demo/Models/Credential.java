package com.example.demo.Models;


import com.example.demo.ModelsDB.CredentialDbModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Credential {
    private int id;
    private String username;
    private String password;

    public Credential(CredentialDbModel model){
        this.id = model.getId();
        this.username = model.getUsername();
        this.password = model.getPassword();
    }
}
