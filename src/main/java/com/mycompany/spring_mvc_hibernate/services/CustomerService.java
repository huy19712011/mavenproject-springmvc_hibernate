/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.services;

import com.mycompany.spring_mvc_hibernate.models.Customer;
import java.util.List;

/**
 *
 * @author huynq
 */
public interface CustomerService {

    List<Customer> getAll();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
}
