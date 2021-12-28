package io.robb.jpastuff.jpaonetoone.controllers;

import io.robb.jpastuff.jpaonetoone.services.CustomerService;
import io.robb.jpastuff.jpaonetoone.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<?> readCustomers() {
        try {
            List<Customer> customers = customerService.readCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (RuntimeException err) {
            return new ResponseEntity<>("Cannot get list", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> readCustomer(@PathVariable long id) {
        try {
            Optional<Customer> customer = customerService.readCustomer(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (RuntimeException err) {
            return new ResponseEntity<>("unable to retrieve customer", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        try{
            customerService.createOne(customer);
            return new ResponseEntity<>("Customer "+customer.getFirstName()+ " was created",
                    HttpStatus.OK);
        } catch (RuntimeException err){
            return new ResponseEntity<>("unable to add customer to d.b.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    ResponseEntity<?> deleteCustomer(@RequestBody Customer customer){
        try{
            customerService.deleteOne(customer);
            return new ResponseEntity<>("Customer "+customer.getFirstName()+" deleted", HttpStatus.ACCEPTED);
        } catch(RuntimeException err){
            return new ResponseEntity<>("unable to delete customer",HttpStatus.BAD_REQUEST);
        }
    }
}

