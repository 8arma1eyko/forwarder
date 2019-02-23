package com.logistic.forwarder.controller;

import com.logistic.forwarder.service.CustomerService;
import com.logistic.forwarder.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/customer";

    @Autowired
    private CustomerService customerService;

//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @GetMapping("/")
    List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    Customer findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
       // return customerService.updateCustomer(customer);
        Customer currentCustomer = customerService.findCustomerById(id);

//        if (currentCustomer==null) {
//            System.out.println("User with id " + id + " not found");
//            return new Customer(HttpStatus.NOT_FOUND);
//        }

        currentCustomer.setFirstname(customer.getFirstname());
        currentCustomer.setLastname(customer.getLastname());

        return customerService.updateCustomer(currentCustomer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}
