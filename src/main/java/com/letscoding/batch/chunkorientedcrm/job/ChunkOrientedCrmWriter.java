package com.letscoding.batch.chunkorientedcrm.job;

import com.letscoding.batch.chunkorientedcrm.dbmodel.postgress.Employee;
import com.letscoding.batch.chunkorientedcrm.dto.EmployeeDTO;
import com.letscoding.batch.chunkorientedcrm.repository.postgress.EmployeeRepository;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChunkOrientedCrmWriter implements ItemWriter<Employee> {

    Logger logger= LoggerFactory.getLogger(ChunkOrientedCrmWriter.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public void write(List<? extends Employee> items) throws Exception {
        for(Employee employee:items){
            EmployeeDTO employeeDTO=new EmployeeDTO();
            dozerBeanMapper.map(employee,employeeDTO);
            employeeDTO.setEmpname(employee.getEmpname().toUpperCase());
            dozerBeanMapper.map(employeeDTO,employee);
            employee.setId(employeeDTO.getId());
            employeeRepository.save(employee);
            logger.info(employeeDTO.toString());

        }
    }
}
