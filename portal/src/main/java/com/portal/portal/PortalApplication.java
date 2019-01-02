package com.portal.portal;

import com.utils.commons.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//exclude = MongoAutoConfiguration.class 移除默认自带的mongodb配置
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@Controller
public class PortalApplication {

    @GetMapping("/portal/")
    @ResponseBody
    public String index() {
//        MongoDBUtil.findById()
        return "Hello World!";
    }

    public static void main(String[] args) {
        AppConfig.init();
        SpringApplication.run(PortalApplication.class, args);
    }

}

