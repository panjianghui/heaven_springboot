package com.portal.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class PortalApplication {

    @GetMapping("/portal/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }

}

