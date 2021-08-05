/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.services;

import com.mycompany.spring_mvc_hibernate.dao.CustomerDAO;
import com.mycompany.spring_mvc_hibernate.models.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huynq
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO dao;

    @Override
    @Transactional
    public List<Customer> getAll() {

        return dao.getCustomers();
    }

    // getters and setters
    public CustomerDAO getDao() {
        return dao;
    }

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {

        dao.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {

        return dao.getCustomer(theId);

    }


}
