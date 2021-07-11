package com.domingoslatorre.springthymeleafbeanvalidation.dynamic;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ShopListForm {
    @NotNull @NotBlank
    private String listName;

    @Valid @Size(min = 1, max = 3)
    private List<ShopItem> itens;

}
