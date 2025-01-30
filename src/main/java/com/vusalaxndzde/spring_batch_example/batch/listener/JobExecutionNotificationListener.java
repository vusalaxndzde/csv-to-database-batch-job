package com.vusalaxndzde.spring_batch_example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobExecutionNotificationListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {

        if (jobExecution.getStatus().equals(BatchStatus.STARTED)) {
            log.info("!!! JOB [{}] STARTED!", jobExecution.getJobInstance().getJobName());
        }
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {

            log.info("!!! JOB [{}] FINISHED with {} status!", jobExecution.getJobInstance().getJobName(), jobExecution.getExitStatus().getExitCode());
        }
    }

}
