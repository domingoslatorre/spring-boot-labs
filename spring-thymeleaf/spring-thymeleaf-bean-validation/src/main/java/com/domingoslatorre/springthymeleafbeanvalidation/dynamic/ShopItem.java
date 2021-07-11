package com.domingoslatorre.springthymeleafbeanvalidation.dynamic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem {
    @NotNull @NotBlank
    private String name;
    @Min(value = 1)
    private String quantity;
}
