package com.example.crm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   
     @GetMapping("/")
    public String home() {
      return "redirect:/home/all";
    }
   
    @GetMapping("/login")
    public String viewLogin() {
    
    return "login";
    }
}
