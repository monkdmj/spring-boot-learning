package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class Demo2Application extends AsyncConfigurerSupport {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }


    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(2);
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("GithubLookup-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
