package org.souayrioss.visionarycroftingspringmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {

    @GetMapping(path = "/panier")
    public String panier(){
        return "panier";
    }
}
