package com.example.demo.Crontrollers;


import com.example.demo.Models.Credential;

import com.example.demo.Security.Models.User;
import com.example.demo.Services.CredentialService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("credentials")
@CrossOrigin("*")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;


    @PostMapping()
    public ResponseEntity<User> validate(@RequestBody Credential user
    ){
        Credential data = credentialService.findRecordemail(user.getUsername());
        if(data.getPassword().equals(user.getPassword())){
            String token = getJWTToken(data.getUsername());
            User use = new User();
            use.setUser(data.getUsername());
            use.setToken(token);
            return ResponseEntity.ok(use);
        }else{
            return null;
        }
    }
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    /*@GetMapping()
    public void  hola(){
        System.out.print("hello");
    }*/

    @GetMapping
    public void hi(){
        System.out.println("hola mundo");
    }

}
