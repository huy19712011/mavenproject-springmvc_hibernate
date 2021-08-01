/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.setup_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author huynq
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        return "list-customers";
    }

}
