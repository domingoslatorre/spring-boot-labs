package com.domingoslatorre.springthymeleafbeanvalidation.dynamic;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("shoplist")
@Log
public class ShopListController {
    public static final String SHOP_VIEW_NAME = "shop/index";
    public static final String REDIRECT_ROUTE = "redirect:/";

    @GetMapping
    public ModelAndView create(ShopListForm shopListForm) {
        return new ModelAndView(SHOP_VIEW_NAME);
    }

    @PostMapping
    public ModelAndView save(@Valid ShopListForm shopListForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView(SHOP_VIEW_NAME);
        }
        log.info(shopListForm.toString());
        return new ModelAndView(REDIRECT_ROUTE);
    }
}
