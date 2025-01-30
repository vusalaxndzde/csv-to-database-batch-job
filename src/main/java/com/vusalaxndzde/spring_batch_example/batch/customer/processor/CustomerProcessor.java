package com.vusalaxndzde.spring_batch_example.batch.customer.processor;

import com.vusalaxndzde.spring_batch_example.entity.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {

        customer.setEmail(customer.getEmail().toLowerCase());

        return customer;
    }

}
