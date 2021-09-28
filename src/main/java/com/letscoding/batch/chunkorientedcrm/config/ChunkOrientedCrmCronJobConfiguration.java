package com.letscoding.batch.chunkorientedcrm.config;

import com.letscoding.batch.chunkorientedcrm.dbmodel.postgress.Employee;
import com.letscoding.batch.chunkorientedcrm.job.ChunkOrientedCrmReader;
import com.letscoding.batch.chunkorientedcrm.job.ChunkOrientedCrmWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class ChunkOrientedCrmCronJobConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private  final ChunkOrientedCrmReader chunkOrientedCrmReader;
    private final ChunkOrientedCrmWriter chunkOrientedCrmWriter;

    private final JobBuilderFactory jobs;


    public Step jobStep(){
        return stepBuilderFactory.get("chunkOrientedCrmCronJobStep")
                .<Employee,Employee>chunk(20)
                .reader(chunkOrientedCrmReader.getEmpList(LocalDate.now()))
                .writer(chunkOrientedCrmWriter)
                .build();
    }

    @Bean
    public Job chunkOrientedCrmCronJob(){
        return jobs
                .get("taskletsJob")
                .start(jobStep()).build();
    }

}
