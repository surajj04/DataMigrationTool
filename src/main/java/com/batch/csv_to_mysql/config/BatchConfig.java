package com.batch.csv_to_mysql.config;

import com.batch.csv_to_mysql.model.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    public Job jobBean(JobRepository jobRepository, JobCompletionNotificationImpl listener, Step steps) {
        return new JobBuilder("job", jobRepository)
                .listener(listener)
                .start(steps)
                .build();
    }

    @Bean
    public Step steps(JobRepository jobRepository, JpaTransactionManager transactionManager, ItemReader<Customer> reader, ItemProcessor<Customer, Customer> processor, ItemWriter<Customer> itemWriter) {
        return new StepBuilder("jobStep", jobRepository)
                .<Customer, Customer>chunk(10, transactionManager)  // Using JpaTransactionManager for transaction management
                .reader(reader)
                .processor(processor)
                .writer(itemWriter)
                .build();
    }

    //    reader
    @Bean
    public FlatFileItemReader<Customer> reader() {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("itemReader")
                .resource(new ClassPathResource("customers-100.csv"))
                .delimited()
                .names("customerId", "firstName", "lastName", "company", "city", "phone", "email")
                .targetType(Customer.class)
                .build();
    }


    @Bean
    public ItemProcessor<Customer, Customer> processor() {
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<Customer> itemWriter(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Customer>()
                .sql("insert into customer(customerid, name, phone, email, city, company) values(:customerid, :name, :phone, :email, :city, :company)")
                .dataSource(dataSource)
                .beanMapped()
                .build();

    }
}
