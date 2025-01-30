package com.vusalaxndzde.spring_batch_example.batch.customer;

import com.vusalaxndzde.spring_batch_example.entity.Customer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomerItemWriterConfig {

    @Bean
    public JdbcBatchItemWriter<Customer> customerJdbcItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Customer>()
                .sql("INSERT INTO customers (id, first_name, last_name, email) VALUES (:id, :firstName, :lastName, :email) " +
                        "ON DUPLICATE KEY UPDATE first_name = VALUES(first_name), last_name = VALUES(last_name), email = VALUES(email)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

}
