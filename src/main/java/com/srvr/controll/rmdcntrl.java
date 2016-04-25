package com.srvr.controll;

import groovy.transform.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reminder")
public class rmdcntrl {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String GetReminder(ModelMap model){
        return request.chisla();
    }
}
