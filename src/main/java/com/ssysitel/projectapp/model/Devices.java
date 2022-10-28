package com.ssysitel.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Devices implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String module;
    private String typeOfEquipment;
    private String position;
    private int speed;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "id_accounts")
    private Accounts accounts;
    public Devices(String module, String typeOfEquipment, String position, int speed, Users user, Accounts account,boolean active)
    {
        this.module=module;
        this.typeOfEquipment=typeOfEquipment;
        this.position=position;
        this.speed=speed;
        this.users=user;
        this.accounts=account;
        this.active=active;
    }



}