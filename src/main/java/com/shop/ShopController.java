package com.shop;

import ch.qos.logback.classic.spi.TurboFilterList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {


    @GetMapping("/about")
    public String about(){

        return "shop controller running successfully";
    }
}
