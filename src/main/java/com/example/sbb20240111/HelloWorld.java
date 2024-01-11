package com.example.sbb20240111;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class HelloWorld
{
    @Bean
    public Job HelloJob(JobRepository jobRepository, Step helloStep1)
    {
        return new JobBuilder("HelloJob", jobRepository)
                .start(helloStep1)
                .build();
    }

    @Bean
    public Step HelloStep1(JobRepository jobRepository, Tasklet HelloStep1Tesklet1, PlatformTransactionManager platformTransactionManager)
    {
        return new StepBuilder("HelloStep1Tesklet1", jobRepository)
                .tasklet(HelloStep1Tesklet1, platformTransactionManager).build();
    }

    @Bean
    public Tasklet HelloStep1Tasklet1()
    {
        return ((contribution, chunkContext) ->
        {
            log.info("Hello World");
            System.out.println("Hello World");
            return RepeatStatus.FINISHED;
        });
    }
}
