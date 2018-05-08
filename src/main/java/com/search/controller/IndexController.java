package com.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nya on 2018/5/8.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

}
