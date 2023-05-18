package com.online.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDTO {

    private String name;
    private double price;
    private int typeId;
    private int brandId;
}
