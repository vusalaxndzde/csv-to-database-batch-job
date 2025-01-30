package com.vusalaxndzde.spring_batch_example.batch.customer;

import com.vusalaxndzde.spring_batch_example.batch.customer.processor.CustomerProcessor;
import com.vusalaxndzde.spring_batch_example.batch.listener.ChuckExecutionListener;
import com.vusalaxndzde.spring_batch_example.batch.listener.StepExecutionNotificationListener;
import com.vusalaxndzde.spring_batch_example.entity.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class CustomerStepConfig {

    private final JobRepository jobRepository;

    public CustomerStepConfig(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Bean
    public Step customerStep(FlatFileItemReader<Customer> customerCsvItemReader,
                             CustomerProcessor customerProcessor, ItemWriter<Customer> customerJdbcItemWriter,
                             DataSourceTransactionManager transactionManager, StepExecutionNotificationListener stepListener,
                             ChuckExecutionListener chuckListener) {

        return new StepBuilder("customerStep", jobRepository)
                .<Customer, Customer>chunk(10, transactionManager)
                .listener(chuckListener)
                .listener(stepListener)
                .reader(customerCsvItemReader)
                .processor(customerProcessor)
                .writer(customerJdbcItemWriter)
                .faultTolerant()
                .retry(Exception.class)
                .retryLimit(5)
                .skip(Exception.class)
                .build();
    }

}
