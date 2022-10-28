package com.ssysitel.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data  @AllArgsConstructor  @NoArgsConstructor @ToString
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String ContactName;
    private String numberOfPhone;
    private boolean active;
    private String role;

    @ManyToOne
    @JoinColumn(name = "")
    private Accounts accounts;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Devices> devices=new ArrayList<>();
    public Users(String name, String pw,String phone,String email,String ContactName,String role,boolean active,Accounts accounts) {
        this.username = name;
        this.password = pw;
        this.numberOfPhone=phone;
        this.email=email;
        this.ContactName=ContactName;
        this.active=active;
        this.role=role;
        this.accounts=accounts;

    }


}