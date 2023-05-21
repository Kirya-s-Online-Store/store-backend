package com.online.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String name;
    private double price;
    private String photoLink;
    private int typeId;
    private int brandId;
    private List<InfoClauseDTO> info;
}
