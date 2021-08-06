/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_hibernate.dao.impl;

import com.mycompany.spring_mvc_hibernate.dao.CustomerDAO;
import com.mycompany.spring_mvc_hibernate.models.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huynq
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject session factory
    @Autowired
    private SessionFactory sessionFactory; // LocalSessionFactoryBean

    @Override
    //@Transactional // use this on service layer
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery
                = currentSession.createQuery("from Customer order by lastName",
                        Customer.class);

        // execute query
        List<Customer> customers = theQuery.getResultList();

        // return result
        return customers;
    }

    // getters and setters
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save or update the customer to database
        //currentSession.save(theCustomer);
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // read from database using primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;

    }

    @Override
    public void deleteCustomer(int theId) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
/*
    // Using hibernate delete()
*/
        //currentSession.delete(getCustomer(theId));
        //currentSession.delete(currentSession.get(Customer.class, theId));

/*
    // Using Hibernate query
*/
        Query theQuery
                = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();

    }

}
