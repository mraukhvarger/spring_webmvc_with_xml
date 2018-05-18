package com.raukhvarger.spring_first.controllers;

import com.raukhvarger.spring_first.MyBean;
import com.raukhvarger.spring_first.MyDAO;
import com.raukhvarger.spring_first.MyDAOService;
import com.raukhvarger.spring_first.MyUser;
import com.raukhvarger.spring_first.entities.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    MyBean myBean;

    @Autowired
    private MyDAOService myDAOService;

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

    @GetMapping(value = "add")
    public ModelAndView add(@RequestParam(value="first", required=true) String first,
                            @RequestParam(value="last", required=true) String last) {
        myDAOService.add(new MyEntity(first, last));

        View view = (model, request, response) -> response.getWriter().write("<h1>OK</h1>");
        ModelAndView modelAndView = new ModelAndView(view);
        return modelAndView;
    }

    @GetMapping(value = "list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("entities", myDAOService.listAll());
        return modelAndView;
    }

}