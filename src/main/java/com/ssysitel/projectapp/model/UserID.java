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
public class UserID implements Serializable {

    @Column(name = "userId")
    Long userID;
    @Column(name = "accountId")
    String accountID;



}
