package com.letscoding.batch.chunkorientedcrm.job;


import com.letscoding.batch.chunkorientedcrm.dbmodel.postgress.Employee;
import com.letscoding.batch.chunkorientedcrm.repository.postgress.EmployeeRepository;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;


@Component
public class ChunkOrientedCrmReader {



    @Autowired
    EmployeeRepository employeeRepository;

    public RepositoryItemReader<Employee> getEmpList(LocalDate localDate){

        RepositoryItemReader<Employee> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(employeeRepository);
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setPageSize(50);
        final HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        repositoryItemReader.setSort(sorts);
        return repositoryItemReader;

    }


}
