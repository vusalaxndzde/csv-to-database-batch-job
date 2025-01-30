package com.vusalaxndzde.spring_batch_example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ChuckExecutionListener implements ChunkListener {

    @Override
    public void beforeChunk(ChunkContext context) {
        log.info("Chunk [{}] started", context.getStepContext().getStepName());
    }

    @Override
    public void afterChunk(ChunkContext context) {
        log.info("Chunk [{}] finished, step status: {}", context.getStepContext().getStepName(),
                context.getStepContext().getStepExecution().getExitStatus().getExitCode());
    }

    @Override
    public void afterChunkError(ChunkContext context) {

        StepExecution stepExecution = context.getStepContext().getStepExecution();
        List<Throwable> failureExceptions = stepExecution.getFailureExceptions();

        log.error("🔴 CHUNK ERROR in step [{}]: {}",
                stepExecution.getStepName(),
                failureExceptions.isEmpty() ? "Unknown error" : failureExceptions.get(0).getMessage()
        );

        log.error("Chunk [{}] rolled back {} time(s).", stepExecution.getStepName(), stepExecution.getRollbackCount());

        for (Throwable exception : failureExceptions) {
            log.error("⛔ Exception: {}", exception.toString(), exception);
        }

        log.error("🚨 FAILED ITEMS BETWEEN: {} {}", stepExecution.getWriteCount(), stepExecution.getReadCount());
    }

}
