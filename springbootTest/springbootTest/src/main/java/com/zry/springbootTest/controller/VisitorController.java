package com.zry.springbootTest.controller;

import com.zry.springbootTest.pojo.Visitor;
import com.zry.springbootTest.repository.VisitorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class VisitorController {

    @Resource
    private VisitorRepository visitorRepository;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        String ip =request.getRemoteAddr();
        Visitor visitor=visitorRepository.findAllByIp(ip);
        if(visitor==null){
            visitor=new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1);
        }else{
            visitor.setTimes(visitor.getTimes()+1);
        }
        visitorRepository.save(visitor);
        return "I have been seen ip "+visitor.getIp()+" "+visitor.getTimes()+" times.";
    }
}
