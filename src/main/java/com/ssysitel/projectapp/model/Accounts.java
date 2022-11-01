package com.ssysitel.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Accounts implements Serializable {
     @Id
     @Column(name = "account_id")
     @NotBlank(message = "Account id must not be empty")
     String accountID;
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String ContactName;
    @Column(length = 50)
    String numberOfPhone;
    @Temporal(TemporalType.DATE)
    Date creationDate;
    @Temporal(TemporalType.DATE)
    Date lastConnection;
    boolean active;
    @Column(length = 50)
    String password;

    @OneToMany(mappedBy = "accounts",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Users> users=new ArrayList<>();

    @OneToMany(mappedBy = "accounts",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Devices> devices=new ArrayList<>();

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
    public Accounts(String accountID,String name,String contactName,String numberOfPhone,Date creationDate,Date lastConnection,String password,boolean active)
    {
        this.accountID=accountID;
        this.name=name;
        this.ContactName=contactName;
        this.numberOfPhone=numberOfPhone;
        this.creationDate=creationDate;
        this.lastConnection=lastConnection;
        this.password=password;
        this.active=active;
    }
}
