package com.lively.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by franCiS on Sep 21, 2014.
 */

@Controller
@RequestMapping(value = "/mock")
public class MockCtrl {
    @RequestMapping(method = RequestMethod.GET, value = "/view")
    @ResponseBody
    public String doGet(@RequestParam("name") String name) {
        return "GET DEMO " + name;
    }

    @RequestMapping(method = RequestMethod.POST, value="/view")
    @ResponseBody
    public Map doPost(@RequestParam("name") String name) {
        Map m = new HashMap();
        m.put("status", "Ok");
        m.put("message", "fine");
        return m;
    }
}
