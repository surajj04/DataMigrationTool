package com.batch.csv_to_mysql.config;

import com.batch.csv_to_mysql.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        String fullName = customer.getFirstname() + " " + customer.getLastname();
        String phone = phoneFilter(customer.getPhone());
        customer.setName(fullName);
        customer.setPhone(phone);

        return customer;
    }


    public static String phoneFilter(String str) {
        String ans = str;
        String[] sub = {".", "x", "001-", "-", "+1", "("};
        for (String s : sub) {
            if (ans.contains(s)) {
                if (s.equals("(")) {
                    if (ans.length() > 5) {
                        ans = ans.substring(5);
                    }
                }else{
                    ans = ans.replace(s, "");
                }
            }
        }
        return ans;
    }

}
