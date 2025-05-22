package com.example.crm.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class ControllerHome {

@GetMapping("/all")
    public String home()
    {
        return "home";
    }

}
