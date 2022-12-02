package com.chapaar.crud.service;

import com.chapaar.crud.exception.NotFoundException;
import com.chapaar.crud.model.Customer;
import com.chapaar.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer getCustomer(long id) throws NotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("CustomerId " + id + " doesn't exist"));
    }

    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void delete(long customerItemId) {
        customerRepository.deleteById(customerItemId);
    }
}
