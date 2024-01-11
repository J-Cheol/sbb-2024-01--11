package com.example.sbb20240111;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatchRunner
{
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job helloJob;

    public void runBatch()
    {
        try
        {
            jobLauncher.run(helloJob, jobParameters());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private JobParameters jobParameters()
    {
        return new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
    }
}
