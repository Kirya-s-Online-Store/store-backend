package com.online.store.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoClauseDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
