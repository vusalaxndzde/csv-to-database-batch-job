package com.vusalaxndzde.spring_batch_example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepExecutionNotificationListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Step [{}] started", stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("Step [{}] finished with {} status", stepExecution.getStepName(), stepExecution.getExitStatus().getExitCode());
        return stepExecution.getExitStatus();
    }

}
