package com.vusalaxndzde.spring_batch_example.batch.customer;

import com.vusalaxndzde.spring_batch_example.batch.listener.JobExecutionNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerJobConfig {

    private final JobRepository jobRepository;

    public CustomerJobConfig(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Bean
    public Job customerJob(Step step, JobExecutionNotificationListener listener) {

        return new JobBuilder("customerJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step)
                .build();
    }

}
