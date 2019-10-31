package com.javagirl.girl.controller;

import com.javagirl.girl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    /**
     * springboot整合thymelef模板
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model){
        List<User>user=new ArrayList<>();
        for (int i=0;i<10;i++){
            User user1=new User();
            user1.setId((long) i);
            user1.setName("javagirl"+i);
            user1.setAddress("深圳"+i);
            user.add(user1);
        }
        model.addAttribute("user",user);
        return "index";
    }
}
