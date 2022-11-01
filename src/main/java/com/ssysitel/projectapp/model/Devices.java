package com.ssysitel.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@IdClass(DeviceId.class)
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Devices implements Serializable {
    @Id
    @NotBlank(message = "Device id must not be empty")
    Long deviceID;
    @Id
    @NotBlank(message = "User id must not be empty")
    Long userID;
    @Id
    @NotBlank(message = "Account id must not be empty")
    String accountId;
    String module;
    String typeOfEquipment;
    String position;
    int speed;
    boolean active;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "userId", insertable = false, updatable = false),
            @JoinColumn(name = "account_id", referencedColumnName = "accountId", insertable = false, updatable = false)
    })
    Users users;

    @ManyToOne
    @JoinColumn(name="account_id",referencedColumnName = "account_id",insertable = false,updatable = false)
    Accounts accounts;
    public Devices(DeviceId id,String module, String typeOfEquipment, String position, int speed,boolean active)
    {
        this.deviceID=id.getDeviceID();
        this.userID=id.getUserID();
        this.accountId=id.getAccountId();
        this.module=module;
        this.typeOfEquipment=typeOfEquipment;
        this.position=position;
        this.speed=speed;
        this.active=active;
    }

    public Devices(long l, Long userID, String accountID, String module, String typeOfEquipment, String position, int speed, boolean active) {
     this.deviceID=l;
     this.userID=userID;
     this.accountId=accountID;
     this.module=module;
     this.typeOfEquipment=typeOfEquipment;
     this.position=position;
     this.speed=speed;
     this.active=active;

    }
}