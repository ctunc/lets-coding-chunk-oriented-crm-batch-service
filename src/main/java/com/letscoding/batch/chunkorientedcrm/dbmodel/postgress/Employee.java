package com.letscoding.batch.chunkorientedcrm.dbmodel.postgress;


import com.letscoding.dbmodel.CoreEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "emp",name = "emp_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements CoreEntity<Long> {


    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="empname")
    private String empname;

    @Column(name="username")
    private String username;

    @Column(name = "status")
    private String status;

}
