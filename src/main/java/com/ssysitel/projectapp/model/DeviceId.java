package com.ssysitel.projectapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Column;
import java.io.Serializable;



@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceId implements Serializable {
    @Column(name = "device_id")
    Long deviceID;
    @Column(name = "user_id")
    Long userID;
    @Column(name = "account_id")
    String accountId;

}
