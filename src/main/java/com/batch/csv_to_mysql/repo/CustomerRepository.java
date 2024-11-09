package com.batch.csv_to_mysql.repo;

import com.batch.csv_to_mysql.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
