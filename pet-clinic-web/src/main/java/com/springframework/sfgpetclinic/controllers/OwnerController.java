package com.springframework.sfgpetclinic.controllers;

import com.springframework.sfgpetclinic.services.OwnerService;
import com.springframework.sfgpetclinic.services.VetService;
import com.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import com.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final VetService vetService;

    public OwnerController(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}
