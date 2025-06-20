package com.pluralsight.dealership.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AppController {

    @GetMapping("/dealers")
    public String showOtherPage() {
        return "dealers"; // This refers to 'dealers.html' in your templates folder
    }
}