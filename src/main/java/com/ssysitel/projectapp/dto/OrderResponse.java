package com.ssysitel.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class OrderResponse {

    private String id_account;
    private String accountName;
    private long numberOfVehicle;

}
