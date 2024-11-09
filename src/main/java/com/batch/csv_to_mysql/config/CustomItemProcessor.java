package com.batch.csv_to_mysql.config;

import com.batch.csv_to_mysql.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        String fullName = customer.getFirstname() + " " + customer.getLastname();
        customer.setName(fullName);

        return customer;
    }
}
