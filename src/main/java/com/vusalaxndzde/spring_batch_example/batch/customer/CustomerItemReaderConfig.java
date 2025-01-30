package com.vusalaxndzde.spring_batch_example.batch.customer;

import com.vusalaxndzde.spring_batch_example.entity.Customer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class CustomerItemReaderConfig {

    private static final Resource CSV = new ClassPathResource("/customers.csv");

    @Bean
    public FlatFileItemReader<Customer> customerCsvItemReader() {

        FlatFileItemReader<Customer> reader = new FlatFileItemReaderBuilder<Customer>()
                .name("customerReader")
                .resource(CSV)
                .delimited()
                .names("id", "firstName", "lastName", "email")
                .targetType(Customer.class)
                .build();

        reader.setLinesToSkip(1);

        return reader;
    }

}
