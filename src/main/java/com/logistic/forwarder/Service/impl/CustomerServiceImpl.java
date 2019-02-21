package com.logistic.forwarder.Service.impl;

import com.logistic.forwarder.Service.CustomerService;
import com.logistic.forwarder.domain.Customer;
import com.logistic.forwarder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}