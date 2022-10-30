package com.ssysitel.projectapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;



@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceId implements Serializable {
    @Column(name = "device_id")
    private Long deviceId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "account_id")
    private String accountId;

}
