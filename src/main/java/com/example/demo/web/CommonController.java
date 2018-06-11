package com.example.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhaoyiwei 2018/5/11 10:34
 */
@Slf4j
@Controller
public class CommonController {

    @RequestMapping("/")
    public ModelAndView index(String name) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", name);
        return mv;
    }

    @RequestMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("main");
    }
}
