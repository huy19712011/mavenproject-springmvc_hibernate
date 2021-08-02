/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.controllers;

import com.mycompany.spring_mvc_hibernate.models.Customer;
import com.mycompany.spring_mvc_hibernate.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author huynq
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject service
    @Autowired
    private CustomerService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomers(Model theModel) {

        // get customers
        List<Customer> customers = service.getAll();

        // add customers to the model
        theModel.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer customer = new Customer();

        theModel.addAttribute("customer", customer);

        return "customer-form";
    }

}
