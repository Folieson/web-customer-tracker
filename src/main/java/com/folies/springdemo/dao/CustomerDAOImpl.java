package com.folies.springdemo.dao;

import com.folies.springdemo.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery("from Customer order by lastName",
                Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        var session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        var session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        var session = sessionFactory.getCurrentSession();
        if (searchName == null || searchName.isEmpty()) return getCustomers();
        var query = session.createQuery("from Customer " +
                "where lower(firstName) like :searchName " +
                "or lower(lastName) like :searchName  " +
                "order by lastName", Customer.class);
        query.setParameter("searchName", searchName.toLowerCase());
        return query.getResultList();
    }
}
