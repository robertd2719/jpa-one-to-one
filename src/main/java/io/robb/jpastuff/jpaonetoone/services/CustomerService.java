package io.robb.jpastuff.jpaonetoone.services;

import io.robb.jpastuff.jpaonetoone.entities.Customer;
import io.robb.jpastuff.jpaonetoone.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    // Find All
    public List<Customer> readCustomers(){
        return customerRepository.findAll();
    }

    // Find One
    public Optional<Customer> readCustomer(long id){
        return customerRepository.findById(id);
    }

    public void createOne(Customer customer){
        customerRepository.save(customer);
    }

    public void updateOne(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteOne(Customer customer){
        customerRepository.delete(customer);
    }


}
