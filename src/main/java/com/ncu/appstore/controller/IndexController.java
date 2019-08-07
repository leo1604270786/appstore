package com.ncu.appstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-06 11:18
 **/
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}