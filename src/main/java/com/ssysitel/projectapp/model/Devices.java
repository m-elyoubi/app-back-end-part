package com.ssysitel.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@IdClass(DeviceId.class)
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Devices implements Serializable {
    @Id
    @NotBlank(message = "Device id must not be empty")
    private Long deviceId;
    @Id
    @NotBlank(message = "User id must not be empty")
    private Long userId;
    @Id
    @NotBlank(message = "Account id must not be empty")
    private String accountId;
    private String module;
    private String typeOfEquipment;
    private String position;
    private int speed;
    private boolean active;
    @ManyToOne
    @JoinColumn(name="user_id",insertable = false,updatable = false)
    private Users users;
    @ManyToOne
    @JoinColumn(name="account_id",insertable = false,updatable = false)
    private Accounts accounts;
    public Devices(DeviceId id,String module, String typeOfEquipment, String position, int speed,boolean active)
    {
        this.deviceId=id.getDeviceId();
        this.userId=id.getUserId();
        this.accountId=id.getAccountId();
        this.module=module;
        this.typeOfEquipment=typeOfEquipment;
        this.position=position;
        this.speed=speed;
        this.active=active;
    }



}