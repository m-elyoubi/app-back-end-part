package com.ssysitel.projectapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(makeFinal=false, level= AccessLevel.PRIVATE)
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@IdClass(UserID.class)
public class Users implements Serializable {
    @Id
    @NotBlank(message = "User id must not be empty")
    Long userID;
    @Id
    @NotBlank(message = "Account id must not be empty")
    String accountID ;
    @Column(length = 50)
    String username;
    @Column(length = 50)
    String password;
    @Column(length = 50)
    String email;
    @Column(length = 50)
    String ContactName;
    String numberOfPhone;
    boolean active;
    String role;

    @ManyToOne
    @JoinColumn(name="accountId",referencedColumnName = "account_id",insertable = false,updatable = false)
    Accounts accounts;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Devices> devices=new ArrayList<>();
    public Users(Long userID,String accountID,String name, String pw,String phone,String email,String ContactName,String role,boolean active) {
       this.userID=userID;
       this.accountID=accountID;
        this.username = name;
        this.password = pw;
        this.numberOfPhone=phone;
        this.email=email;
        this.ContactName=ContactName;
        this.active=active;
        this.role=role;

    }


}