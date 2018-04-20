package com.raukhvarger.spring_first.controllers;

import com.raukhvarger.spring_first.MyBean;
import com.raukhvarger.spring_first.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MyController {

    @Autowired
    MyBean myBean;

    @GetMapping(path = "/")
    public ModelAndView root(@RequestParam(value="first", required=true) String first,
                             @RequestParam(value="last", required=true) String last) throws IOException {
        return hello(first, last);
    }

    @GetMapping(value = "/hello")
    public ModelAndView hello(@RequestParam(value="first", required=true) String first,
                              @RequestParam(value="last", required=true) String last
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new MyUser(first, last));
        modelAndView.setViewName("hello");
        return modelAndView;
    }

}