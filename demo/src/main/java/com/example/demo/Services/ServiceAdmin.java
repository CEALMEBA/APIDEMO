package com.example.demo.Services;


import com.example.demo.Models.Admin;
import com.example.demo.ModelsDB.AdminDB;
import com.example.demo.Repositorys.RepositoryAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

@Service
public class ServiceAdmin {
    @Autowired
    private RepositoryAdmin adminrepo;

    public ServiceAdmin(){

    }

    public Admin createAdmin(Admin adm){
        AdminDB adminsave= adminrepo.save(new AdminDB(adm.getId(),adm.getNames(),adm.getFullname(),adm.getArea(),adm.getStatus(),adm.getEmail()));
        adm.setId(adminsave.getId());
        return adm;
    }

    public void updateAdmin(long adminid ,Admin adm)
    {
        Optional<AdminDB> optAdmin=adminrepo.findById(adminid);
        AdminDB adminFound =optAdmin.get();
        adminFound.setNames(adm.getNames());
        adminFound.setFullname(adm.getFullname());
        adminFound.setArea(adm.getArea());
        adminFound.setStatus(adm.getStatus());
        adminFound.setEmail(adm.getEmail());
        adminrepo.save(adminFound);
    }

    public List<Admin> findAll(){
        Iterator<AdminDB> records=adminrepo.findAll().iterator();
        List<Admin> adminn = new ArrayList();
        while (records.hasNext()) {
          adminn.add(new Admin(records.next())) ;
        }
        return adminn;
    }

    public void deleteAdmin(long id){adminrepo.deleteById(id);}

    public Admin getOneAdmin(long id){
        Optional<AdminDB> byId = adminrepo.findById(id);
        AdminDB admindb =byId.get();
        Admin ad = new Admin(admindb);
        return ad;
    }
}
