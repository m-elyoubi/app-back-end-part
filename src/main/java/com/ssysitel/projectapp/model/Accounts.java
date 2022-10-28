package com.ssysitel.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Accounts implements Serializable {
     @Id
     private  String id;
    @Column(length = 50)
     private String name;
    @Column(length = 50)
    private String ContactName;
    @Column(length = 50)
    private String numberOfPhone;
     @Temporal(TemporalType.DATE)
     private Date creationDate;
     @Temporal(TemporalType.DATE)
     private Date lastConnection;

    private boolean active;

    @Column(length = 50)
    private String password;

    @OneToMany(mappedBy = "accounts",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Users> users=new ArrayList<>();


    @OneToMany(mappedBy = "accounts",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Devices> devices=new ArrayList<>();

    public Accounts(String name,String contactName,String numberOfPhone,Date creationDate,Date lastConnection,String password,boolean active)
    {
        this.name=name;
        this.ContactName=contactName;
        this.numberOfPhone=numberOfPhone;
        this.creationDate=creationDate;
        this.lastConnection=lastConnection;
        this.password=password;
        this.active=active;

    }
    public Accounts(String id,String name,String contactName,String numberOfPhone,Date creationDate,Date lastConnection,String password,boolean active)
    {
        this.id=id;
        this.name=name;
        this.ContactName=contactName;
        this.numberOfPhone=numberOfPhone;
        this.creationDate=creationDate;
        this.lastConnection=lastConnection;
        this.password=password;
        this.active=active;
    }
}
