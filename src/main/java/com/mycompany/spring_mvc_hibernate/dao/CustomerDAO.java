/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.dao;

import com.mycompany.spring_mvc_hibernate.models.Customer;
import java.util.List;

/**
 *
 * @author huynq
 */
public interface CustomerDAO {

    public List<Customer> getCustomers();

}
