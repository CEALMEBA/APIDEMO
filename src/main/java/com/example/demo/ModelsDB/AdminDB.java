package com.example.demo.ModelsDB;

import com.example.demo.Models.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "administradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Names")
    private String Names;
    @Column(name = "Fullname")
    private String Fullname;
    @Column(name = "Area")
    private String Area;
    @Column(name = "status")
    private String Status;
    @Column(name = "Email")
    private String Email;

    private AdminDB (Admin admin){
        this.id=admin.getId();
        this.Names=admin.getNames();
        this.Fullname=admin.getFullname();
        this.Area=admin.getArea();
        this.Status=admin.getStatus();
        this.Email=admin.getEmail();

    }
}
