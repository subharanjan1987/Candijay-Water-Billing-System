/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bert
 */
@Controller
public class AccessDeniedController {
    
    @RequestMapping(value="/error403", method=RequestMethod.GET)
    public String accessDenied(ModelMap model){
        model.addAttribute("type", "Access Denied");
        model.addAttribute("message", "You don't have enough permission to access this page.");
        return "errors";
    }
    
}
