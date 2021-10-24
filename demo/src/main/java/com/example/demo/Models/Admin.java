package com.example.demo.Models;

import com.example.demo.ModelsDB.AdminDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int id;
    private String Names;
    private String Fullname;
    private String Area;
    private String Status;
    private String Email;


    public Admin(AdminDB admin){
        this.id=admin.getId();
        this.Names=admin.getNames();
        this.Fullname=admin.getFullname();
        this.Area=admin.getArea();
        this.Status=admin.getStatus();
        this.Email=admin.getEmail();

    }

}
