package com.letscoding.batch.chunkorientedcrm.repository.postgress;

import com.letscoding.batch.chunkorientedcrm.dbmodel.postgress.Employee;
import com.letscoding.repository.common.BaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BaseJpaRepository<Employee,Long> {

}
