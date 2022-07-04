package com.dh.concessionariadeveiculos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private UUID id;
    private int price;
    private String brand;
    private String model;
    private Date manufacturingDate;
}
