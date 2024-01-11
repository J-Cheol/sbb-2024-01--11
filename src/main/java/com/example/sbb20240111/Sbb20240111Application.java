package com.example.sbb20240111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sbb20240111Application
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(Sbb20240111Application.class, args);

        BatchRunner batchRunner = context.getBean(BatchRunner.class);
        batchRunner.runBatch();
    }

}
